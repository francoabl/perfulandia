package com.perfulandia.cl.perfulandia.controller;

import com.perfulandia.cl.perfulandia.model.Sucursal;
import com.perfulandia.cl.perfulandia.service.SucursalService;
import com.perfulandia.cl.perfulandia.assembler.SucursalModelAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/api/v2/sucursales")
public class SucursalControllerV2 {

    @Autowired
    private SucursalService sucursalService;

    @Autowired
    private SucursalModelAssembler assembler;

    @GetMapping
    public CollectionModel<EntityModel<Sucursal>> getAll() {
        List<EntityModel<Sucursal>> sucursales = sucursalService.findAll().stream()
                .map(assembler::toModel)
                .toList();

        return CollectionModel.of(sucursales,
                linkTo(methodOn(SucursalControllerV2.class).getAll()).withSelfRel());
    }

    @GetMapping("/{id}")
    public EntityModel<Sucursal> getById(@PathVariable Long id) {
        Sucursal sucursal = sucursalService.findById(id)
                .orElseThrow(() -> new RuntimeException("Sucursal no encontrada"));
        return assembler.toModel(sucursal);
    }

    @PostMapping
    public EntityModel<Sucursal> create(@RequestBody Sucursal sucursal) {
        Sucursal nuevaSucursal = sucursalService.crearSucursal(sucursal);
        return assembler.toModel(nuevaSucursal);
    }

    @PutMapping("/{id}")
    public EntityModel<Sucursal> update(@PathVariable Long id, @RequestBody Sucursal sucursal) {
        Sucursal sucursalActualizada = sucursalService.actualizarSucursal(id, sucursal);
        return assembler.toModel(sucursalActualizada);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        sucursalService.eliminarSucursal(id);
    }
}
