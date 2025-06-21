package com.perfulandia.cl.perfulandia.controller;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;


import com.perfulandia.cl.perfulandia.assembler.ClienteModelAssembler;
import com.perfulandia.cl.perfulandia.model.Cliente;
import com.perfulandia.cl.perfulandia.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2/clientes")
public class ClienteControllerV2 {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteModelAssembler assembler;

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<Cliente>> obtenerClientePorId(@PathVariable Long id) {
        return clienteRepository.findById(id)
                .map(assembler::toModel)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<CollectionModel<EntityModel<Cliente>>> listarClientes() {
        List<EntityModel<Cliente>> clientes = clienteRepository.findAll().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        CollectionModel<EntityModel<Cliente>> collectionModel = CollectionModel.of(clientes,
                linkTo(ClienteControllerV2.class).withSelfRel());

        return ResponseEntity.ok(collectionModel);
    }
}