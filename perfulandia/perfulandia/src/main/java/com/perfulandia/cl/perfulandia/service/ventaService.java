package com.perfulandia.cl.perfulandia.service;

import com.perfulandia.cl.perfulandia.model.venta;
import com.perfulandia.cl.perfulandia.repository.ventaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ventaService {

    @Autowired
    private ventaRepository ventaRepository;

    public List<venta> getAllVentas() {
        return ventaRepository.findAll();
    }

    public Optional<venta> getVentaById(Long id) {
        return ventaRepository.findById(id);
    }

    public venta createVenta(venta venta) {
        venta.setTotal(venta.getPrecio() * venta.getCantidad());
        return ventaRepository.save(venta);
    }

    public venta updateVenta(Long id, venta ventaDetails) {
        return ventaRepository.findById(id).map(venta -> {
            venta.setNombreProducto(ventaDetails.getNombreProducto());
            venta.setCantidad(ventaDetails.getCantidad());
            venta.setPrecio(ventaDetails.getPrecio());
            venta.setTotal(ventaDetails.getPrecio() * ventaDetails.getCantidad());
            return ventaRepository.save(venta);
        }).orElseThrow(() -> new RuntimeException("Venta no encontrada."));
    }

    public void deleteVenta(Long id) {
        ventaRepository.deleteById(id);
    }
}
