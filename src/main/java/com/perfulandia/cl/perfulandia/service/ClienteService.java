package com.perfulandia.cl.perfulandia.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perfulandia.cl.perfulandia.model.Cliente;
import com.perfulandia.cl.perfulandia.repository.ClienteRepository;

@Service
public class ClienteService {

@Autowired
private ClienteRepository clienteRepository;

public List<Cliente> getAllClientes() {
    return clienteRepository.findAll();
}

public Optional<Cliente> getClienteById(Long id) {
    return clienteRepository.findById(id);
}

public Cliente createCliente(Cliente cliente) {
    return clienteRepository.save(cliente);
}

public Cliente actualizarCliente(Long id, Cliente clienteDetails) {
    return clienteRepository.findById(id).map(cliente -> {
        cliente.setNombre(clienteDetails.getNombre());
        cliente.setApellido(clienteDetails.getApellido());
        cliente.setCorreo(clienteDetails.getCorreo());
        return clienteRepository.save(cliente);
    }).orElseThrow(() -> new RuntimeException("Cliente no encontrado con ID: " + id));
}

public void deleteCliente(Long id) {
    clienteRepository.deleteById(id);
}
}