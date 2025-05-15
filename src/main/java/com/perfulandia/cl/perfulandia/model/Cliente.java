package com.perfulandia.cl.perfulandia.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "clientes")
@Data
public class Cliente {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private String nombre;
private String apellido;
private String rut;

@Column(unique = true)
private String correo;

private String telefono;
}