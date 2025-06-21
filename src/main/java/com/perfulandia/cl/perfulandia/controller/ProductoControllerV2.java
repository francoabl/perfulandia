package com.perfulandia.cl.perfulandia.controller;

import com.perfulandia.cl.perfulandia.model.Producto;
import com.perfulandia.cl.perfulandia.service.ProductoService;
import com.perfulandia.cl.perfulandia.assembler.ProductoModelAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/api/v2/productos")
public class ProductoControllerV2 {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private ProductoModelAssembler assembler;

    @GetMapping
    public CollectionModel<EntityModel<Producto>> getAll() {
        List<EntityModel<Producto>> productos = productoService.findAll().stream()
                .map(assembler::toModel)
                .toList();

        return CollectionModel.of(productos,
                linkTo(methodOn(ProductoControllerV2.class).getAll()).withSelfRel());
    }

    @GetMapping("/{id}")
    public EntityModel<Producto> getById(@PathVariable Long id) {
        Producto producto = productoService.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        return assembler.toModel(producto);
    }

    @PostMapping
    public EntityModel<Producto> create(@RequestBody Producto producto) {
        Producto nuevo = productoService.crearProducto(producto);
        return assembler.toModel(nuevo);
    }

    @PutMapping("/{id}")
    public EntityModel<Producto> update(@PathVariable Long id, @RequestBody Producto producto) {
        Producto actualizado = productoService.actualizarProducto(id, producto);
        return assembler.toModel(actualizado);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productoService.eliminarProducto(id);
    }
}
