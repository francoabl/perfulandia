package com.perfulandia.cl.perfulandia.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.perfulandia.cl.perfulandia.model.Cliente;
import com.perfulandia.cl.perfulandia.service.ClienteService;

@RestController
@RequestMapping("/api/administrador/clientes")
public class ClienteController {


@Autowired
private ClienteService clienteService;

@GetMapping
public List<Cliente> getAllClientes() {
    return clienteService.getAllClientes();
}

@GetMapping("/{id}")
public Optional<Cliente> getClienteById(@PathVariable Long id) {
    return clienteService.getClienteById(id);
}

@PostMapping
public Cliente createCliente(@RequestBody Cliente cliente) {
    return clienteService.createCliente(cliente);
}

@PutMapping("/{id}")
public Cliente updateCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
    return clienteService.updateCliente(id, cliente);
}

@DeleteMapping("/{id}")
public void deleteCliente(@PathVariable Long id) {
    clienteService.deleteCliente(id);
}
}
