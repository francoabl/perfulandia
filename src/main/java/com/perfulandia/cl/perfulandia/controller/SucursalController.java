package com.perfulandia.cl.perfulandia.controller;

import com.perfulandia.cl.perfulandia.model.Sucursal;
import com.perfulandia.cl.perfulandia.service.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/sucursales")
public class SucursalController {

    @Autowired
    private SucursalService sucursalService;

    @GetMapping
    public List<Sucursal> obtenerSucursales() {
        return sucursalService.findAll();
    }

    @GetMapping("/{id}")
    public Sucursal obtenerSucursalPorId(@PathVariable Long id) {
        return sucursalService.findById(id)
                .orElseThrow(() -> new RuntimeException("Sucursal no encontrada"));
    }

    @PostMapping
    public Sucursal crearSucursal(@RequestBody Sucursal sucursal) {
        return sucursalService.crearSucursal(sucursal);
    }

    @PutMapping("/{id}")
    public Sucursal actualizarSucursal(@PathVariable Long id, @RequestBody Sucursal sucursal) {
        return sucursalService.actualizarSucursal(id, sucursal);
    }

    @PatchMapping("/{id}")
    public Sucursal actualizarParcial(@PathVariable Long id, @RequestBody Map<String, Object> cambios) {
        Sucursal sucursal = sucursalService.findById(id)
                .orElseThrow(() -> new RuntimeException("Sucursal no encontrada"));

        cambios.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(Sucursal.class, key);
            if (field != null) {
                field.setAccessible(true);
                ReflectionUtils.setField(field, sucursal, value);
            }
        });

        return sucursalService.crearSucursal(sucursal);
    }

    @DeleteMapping("/{id}")
    public void eliminarSucursal(@PathVariable Long id) {
        sucursalService.eliminarSucursal(id);
    }
}
