package com.netek.app.practica3.repository;

import com.netek.app.practica3.entities.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface IProductoDAO extends CrudRepository<Producto, Integer> {
    @Query("SELECT p FROM Producto p WHERE p.nombre = :nombre")
    Optional<List<Producto>> findByName(String nombre);
}
