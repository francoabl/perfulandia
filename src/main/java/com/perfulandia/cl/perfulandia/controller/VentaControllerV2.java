package com.perfulandia.cl.perfulandia.controller;

import com.perfulandia.cl.perfulandia.model.Venta;
import com.perfulandia.cl.perfulandia.service.VentaService;
import com.perfulandia.cl.perfulandia.assembler.VentaModelAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/api/v2/ventas")
public class VentaControllerV2 {

    @Autowired
    private VentaService ventaService;

    @Autowired
    private VentaModelAssembler assembler;

    @GetMapping
    public CollectionModel<EntityModel<Venta>> getAll() {
        List<EntityModel<Venta>> ventas = ventaService.getAllVentas().stream()
                .map(assembler::toModel)
                .toList();

        return CollectionModel.of(ventas,
                linkTo(methodOn(VentaControllerV2.class).getAll()).withSelfRel());
    }

    @GetMapping("/{id}")
    public EntityModel<Venta> getById(@PathVariable Long id) {
        Venta venta = ventaService.getVentaById(id)
                .orElseThrow(() -> new RuntimeException("Venta no encontrada"));
        return assembler.toModel(venta);
    }

    @PostMapping
    public EntityModel<Venta> create(@RequestBody Venta venta) {
        Venta nuevaVenta = ventaService.saveVenta(venta);
        return assembler.toModel(nuevaVenta);
    }

    @PutMapping("/{id}")
    public EntityModel<Venta> update(@PathVariable Long id, @RequestBody Venta venta) {
        Venta ventaActualizada = ventaService.updateVenta(id, venta);
        return assembler.toModel(ventaActualizada);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        ventaService.deleteVenta(id);
    }
}
