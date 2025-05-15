package com.perfulandia.cl.perfulandia.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "ventas")
@Data
public class venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombreProducto;

    @Column(nullable = false)
    private int cantidad;

    @Column(nullable = false)
    private double precio;

    @Column(nullable = false)
    private double total;

    @Column(nullable = false)
    private LocalDateTime fechaVenta;

    public venta() {
        this.fechaVenta = LocalDateTime.now();
    }
}
