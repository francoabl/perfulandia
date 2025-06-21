package com.perfulandia.cl.perfulandia.assembler;

import com.perfulandia.cl.perfulandia.controller.VentaControllerV2;
import com.perfulandia.cl.perfulandia.model.Venta;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class VentaModelAssembler implements RepresentationModelAssembler<Venta, EntityModel<Venta>> {

    @Override
    public EntityModel<Venta> toModel(Venta venta) {
        return EntityModel.of(venta,
                linkTo(methodOn(VentaControllerV2.class).getById(venta.getId())).withSelfRel(),
                linkTo(methodOn(VentaControllerV2.class).getAll()).withRel("ventas"));
    }
}