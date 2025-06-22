package com.perfulandia.cl.perfulandia.service;

import com.perfulandia.cl.perfulandia.model.Sucursal;
import com.perfulandia.cl.perfulandia.repository.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SucursalService {

    @Autowired
    private SucursalRepository sucursalRepository;

    public List<Sucursal> getAllSucursales() {
        return sucursalRepository.findAll();
    }

    public Optional<Sucursal> getSucursalById(Long id) {
        return sucursalRepository.findById(id);
    }

    public Sucursal crearSucursal(Sucursal sucursal) {
        return sucursalRepository.save(sucursal);
    }

    public Sucursal actualizarSucursal(Long id, Sucursal sucursalDetails) {
        return sucursalRepository.findById(id).map(sucursal -> {
            sucursal.setNombre(sucursalDetails.getNombre());
            sucursal.setDireccion(sucursalDetails.getDireccion());
            sucursal.setTelefono(sucursalDetails.getTelefono());
            sucursal.setCiudad(sucursalDetails.getCiudad());
            return sucursalRepository.save(sucursal);
        }).orElseThrow(() -> new RuntimeException("Sucursal no encontrada."));
    }

    public void eliminarSucursal(Long id) {
        sucursalRepository.deleteById(id);
    }
}

