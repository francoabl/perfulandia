package com.perfulandia.cl.perfulandia.controller;

import com.perfulandia.cl.perfulandia.model.venta;
import com.perfulandia.cl.perfulandia.service.ventaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/empleado/ventas")
public class ventaController {

    @Autowired
    private ventaService ventaService;

    @GetMapping
    public List<venta> getAllVentas() {
        return ventaService.getAllVentas();
    }

    @GetMapping("/{id}")
    public Optional<venta> getVentaById(@PathVariable Long id) {
        return ventaService.getVentaById(id);
    }

    @PostMapping
    public venta createVenta(@RequestBody venta venta) {
        return ventaService.createVenta(venta);
    }

    @PutMapping("/{id}")
    public venta updateVenta(@PathVariable Long id, @RequestBody venta venta) {
        return ventaService.updateVenta(id, venta);
    }

    @DeleteMapping("/{id}")
    public void deleteVenta(@PathVariable Long id) {
        ventaService.deleteVenta(id);
    }
}
