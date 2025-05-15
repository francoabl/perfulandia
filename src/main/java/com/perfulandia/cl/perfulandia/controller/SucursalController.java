package com.perfulandia.cl.perfulandia.controller;

import com.perfulandia.cl.perfulandia.model.Sucursal;
import com.perfulandia.cl.perfulandia.service.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sucursales")
public class SucursalController {

    @Autowired
    private SucursalService sucursalService;

    @GetMapping
    public List<Sucursal> obtenerSucursales() {
        return sucursalService.getAllSucursales();
    }

    @GetMapping("/{id}")
    public Optional<Sucursal> obtenerSucursalPorId(@PathVariable Long id) {
        return sucursalService.getSucursalById(id);
    }

    @PostMapping
    public Sucursal crearSucursal(@RequestBody Sucursal sucursal) {
        return sucursalService.crearSucursal(sucursal);
    }

    @PutMapping("/{id}")
    public Sucursal actualizarSucursal(@PathVariable Long id, @RequestBody Sucursal sucursal) {
        return sucursalService.actualizarSucursal(id, sucursal);
    }

    @DeleteMapping("/{id}")
    public void eliminarSucursal(@PathVariable Long id) {
        sucursalService.eliminarSucursal(id);
    }
}
