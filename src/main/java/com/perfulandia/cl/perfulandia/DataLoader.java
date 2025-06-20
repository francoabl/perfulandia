package com.perfulandia.cl.perfulandia;

import com.perfulandia.cl.perfulandia.model.Cliente;
import com.perfulandia.cl.perfulandia.repository.ClienteRepository;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker();

        for (int i = 0; i < 50; i++) {
            Cliente cliente = new Cliente();
            cliente.setNombre(faker.name().firstName());
            cliente.setApellido(faker.name().lastName());
            cliente.setCorreo(faker.internet().emailAddress());

            clienteRepository.save(cliente);
        }

        System.out.println("Datos de clientes cargados con Faker");
    }
}
