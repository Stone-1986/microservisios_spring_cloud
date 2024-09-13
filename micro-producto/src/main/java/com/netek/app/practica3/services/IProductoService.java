package com.netek.app.practica3.services;

import com.netek.app.practica3.entities.Producto;

import java.util.List;

public interface IProductoService {
    Producto save(Producto producto);

    Boolean update(Producto producto);

    void deleteById(int id);

    Producto findByName(String nombre);

    Producto findById(int id);

    List<Producto> findAll();
}
