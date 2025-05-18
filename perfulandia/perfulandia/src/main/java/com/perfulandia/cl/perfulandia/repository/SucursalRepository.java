package com.perfulandia.cl.perfulandia.repository;

import com.perfulandia.cl.perfulandia.model.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SucursalRepository extends JpaRepository<Sucursal, Long> {
    List<Sucursal> findByCiudadContainingIgnoreCase(String ciudad);
}
