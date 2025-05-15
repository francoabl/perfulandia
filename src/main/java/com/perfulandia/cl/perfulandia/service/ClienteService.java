package com.perfulandia.cl.perfulandia.service;

import com.perfulandia.cl.perfulandia.model.Cliente;
import com.perfulandia.cl.perfulandia.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

public Cliente updateCliente(Long id, Cliente clienteDetails) {
    return clienteRepository.findById(id).map(cliente -> {
        cliente.setNombre(clienteDetails.getNombre());
        cliente.setApellido(clienteDetails.getApellido());
        cliente.setRut(clienteDetails.getRut());
        cliente.setCorreo(clienteDetails.getCorreo());
        cliente.setTelefono(clienteDetails.getTelefono());
        return clienteRepository.save(cliente);
    }).orElseThrow(() -> new RuntimeException("Cliente no encontrado con ID: " + id));
}

public void deleteCliente(Long id) {
    clienteRepository.deleteById(id);
}
}