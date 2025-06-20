package com.perfulandia.cl.perfulandia.service;

import com.perfulandia.cl.perfulandia.model.Cliente;
import com.perfulandia.cl.perfulandia.model.Producto;
import com.perfulandia.cl.perfulandia.model.Venta;
import com.perfulandia.cl.perfulandia.repository.ClienteRepository;
import com.perfulandia.cl.perfulandia.repository.ProductoRepository;
import com.perfulandia.cl.perfulandia.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VentaService {

    private final VentaRepository ventaRepository;
    private final ProductoRepository productoRepository;
    private final ClienteRepository clienteRepository;

    @Autowired
    public VentaService(VentaRepository ventaRepository,
                        ProductoRepository productoRepository,
                        ClienteRepository clienteRepository) {
        this.ventaRepository = ventaRepository;
        this.productoRepository = productoRepository;
        this.clienteRepository = clienteRepository;
    }

    public List<Venta> getAllVentas() {
        return ventaRepository.findAll();
    }

    public Optional<Venta> getVentaById(Long id) {
        return ventaRepository.findById(id);
    }

    public Venta saveVenta(Venta venta) {
        return ventaRepository.save(venta);
    }

    public Venta updateVenta(Long id, Venta venta) {
        venta.setId(id);
        return ventaRepository.save(venta);
    }

    public void deleteVenta(Long id) {
        ventaRepository.deleteById(id);
    }

    public Optional<Producto> getProductoById(Long id) {
        return productoRepository.findById(id);
    }

    public Optional<Cliente> getClienteById(Long id) {
        return clienteRepository.findById(id);
    }
}
