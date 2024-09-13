package com.netek.app.practica3.controller;

import com.netek.app.practica3.entities.Producto;
import com.netek.app.practica3.services.IProductoService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IProductoController {
    private final IProductoService service;

    public IProductoController(IProductoService service) {
        this.service = service;
    }

    @GetMapping("/productos/by/nombre/{nombre}")
    public Producto findByName(@PathVariable("nombre") String nombre) {
        return service.findByName(nombre);
    }

    @GetMapping("/productos")
    public List<Producto> findAll() {
        return service.findAll();
    }

    @GetMapping("/productos/{id}")
    public Producto findId(@PathVariable("id") int id) {
        return service.findById(id);
    }

    @PostMapping("/producto")
    public Producto saveProduct(@RequestBody Producto producto) {
        return service.save(producto);
    }

    @PutMapping("/producto")
    public Boolean updateProduct(@RequestBody Producto producto) {
        return service.update(producto);
    }

    @DeleteMapping("/producto/{id}")
    public void deleteById(@PathVariable("id") int id) {
        service.deleteById(id);
    }
}
