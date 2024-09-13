package com.netec.ms_carrito.controller;

import com.netec.ms_carrito.entities.Producto;
import com.netec.ms_carrito.services.ICarritoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/carrito")
@RequiredArgsConstructor
public class CarritoController {
    private final ICarritoService service;

    @PostMapping("/{id}")
    public boolean addProduct(@PathVariable("id") int id) {
        return service.insertArticulo(id);
    }

    @GetMapping
    public List<Producto> showAllProducts() {
        return service.showAllProducts();
    }

    //agregar la funcionalidad para saber el total a pagar
}
