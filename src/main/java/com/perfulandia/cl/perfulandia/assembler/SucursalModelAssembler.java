package com.perfulandia.cl.perfulandia.assembler;

import com.perfulandia.cl.perfulandia.controller.SucursalControllerV2;
import com.perfulandia.cl.perfulandia.model.Sucursal;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class SucursalModelAssembler implements RepresentationModelAssembler<Sucursal, EntityModel<Sucursal>> {

    @Override
    public EntityModel<Sucursal> toModel(Sucursal sucursal) {
        return EntityModel.of(sucursal,
                linkTo(methodOn(SucursalControllerV2.class).getById(sucursal.getId())).withSelfRel(),
                linkTo(methodOn(SucursalControllerV2.class).getAll()).withRel("sucursales"));
    }
}
