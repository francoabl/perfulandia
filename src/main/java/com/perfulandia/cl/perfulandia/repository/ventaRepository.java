package com.perfulandia.cl.perfulandia.repository;

import com.perfulandia.cl.perfulandia.model.venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ventaRepository extends JpaRepository<venta, Long> {
    List<venta> findByNombreProducto(String nombreProducto);
}
