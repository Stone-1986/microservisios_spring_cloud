package com.netec.ms_carrito.services;

import com.netec.ms_carrito.entities.Producto;

import java.util.List;

public interface ICarritoService {
    boolean insertArticulo(int id);

    List<Producto> showAllProducts();
}
