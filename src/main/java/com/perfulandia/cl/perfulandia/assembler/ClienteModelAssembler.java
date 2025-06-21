package com.perfulandia.cl.perfulandia.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import com.perfulandia.cl.perfulandia.controller.ClienteControllerV2;
import com.perfulandia.cl.perfulandia.model.Cliente;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class ClienteModelAssembler implements RepresentationModelAssembler<Cliente, EntityModel<Cliente>> {

    @Override
    public EntityModel<Cliente> toModel(Cliente cliente) {
        return EntityModel.of(cliente,
            linkTo(methodOn(ClienteControllerV2.class).obtenerClientePorId(cliente.getId())).withSelfRel(),
            linkTo(methodOn(ClienteControllerV2.class).listarClientes()).withRel("clientes")
        );
    }
}
