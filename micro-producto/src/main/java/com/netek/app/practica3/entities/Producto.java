package com.netek.app.practica3.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "productos")
@Getter
@Setter
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 50)
    private String nombre;
    @Column(length = 50)
    private String marca;
    @Column(length = 150)
    private String descripcion;
    private BigDecimal precio;

    public Producto() {
    }

    public Producto(Integer id, String nombre, String marca, String descripcion, BigDecimal precio) {
        this.id = id;
        this.nombre = nombre;
        this.marca = marca;
        this.descripcion = descripcion;
        this.precio = precio;
    }
}
