package com.perfulandia.cl.perfulandia.controller;

import com.perfulandia.cl.perfulandia.model.Venta;
import com.perfulandia.cl.perfulandia.service.VentaService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/ventas")
@CrossOrigin(origins = "*")
public class VentaController {

    private final VentaService ventaService;

    public VentaController(VentaService ventaService) {
        this.ventaService = ventaService;
    }

    @GetMapping
    public List<Venta> getAll() {
        return ventaService.getAllVentas();
    }

    @GetMapping("/{id}")
    public Venta getById(@PathVariable Long id) {
        return ventaService.getVentaById(id)
                .orElseThrow(() -> new RuntimeException("Venta no encontrada con ID: " + id));
    }

    @PostMapping
    public Venta create(@Valid @RequestBody Venta venta) {
        return ventaService.saveVenta(venta);
    }

    @PutMapping("/{id}")
    public Venta update(@PathVariable Long id, @Valid @RequestBody Venta venta) {
        return ventaService.updateVenta(id, venta);
    }

    @PatchMapping("/{id}")
    public Venta patch(@PathVariable Long id, @RequestBody Map<String, Object> cambios) {
        Venta venta = ventaService.getVentaById(id)
                .orElseThrow(() -> new RuntimeException("Venta no encontrada"));

        if (cambios.containsKey("producto")) {
            Map<String, Object> productoMap = (Map<String, Object>) cambios.get("producto");
            Long productoId = ((Number) productoMap.get("id")).longValue();
            venta.setProducto(ventaService.getProductoById(productoId)
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado")));
        }

        if (cambios.containsKey("cliente")) {
            Map<String, Object> clienteMap = (Map<String, Object>) cambios.get("cliente");
            Long clienteId = ((Number) clienteMap.get("id")).longValue();
            venta.setCliente(ventaService.getClienteById(clienteId)
                    .orElseThrow(() -> new RuntimeException("Cliente no encontrado")));
        }

        if (cambios.containsKey("cantidad")) {
            venta.setCantidad(((Number) cambios.get("cantidad")).intValue());
        }

        if (cambios.containsKey("fecha")) {
            venta.setFecha(LocalDate.parse((String) cambios.get("fecha")));
        }

        return ventaService.saveVenta(venta);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        ventaService.deleteVenta(id);
    }
}
