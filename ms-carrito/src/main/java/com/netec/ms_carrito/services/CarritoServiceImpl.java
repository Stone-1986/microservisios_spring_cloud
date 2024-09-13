package com.netec.ms_carrito.services;

import com.netec.ms_carrito.entities.Carrito;
import com.netec.ms_carrito.entities.Producto;
import com.netec.ms_carrito.feing.IArticuloFeign;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class CarritoServiceImpl implements ICarritoService {
    private final Carrito carrito;
    private final IArticuloFeign feign;

    @Override
    @CircuitBreaker(name = "productos", fallbackMethod = "productoFallback")
    public boolean insertArticulo(int id) {
        Producto producto = feign.findById(id);
        if (producto != null) {
            carrito.getProductos().add(producto);
            return true;
        }
        return false;
    }

    @Override
    public List<Producto> showAllProducts() {
        return carrito.getProductos();
    }

    private boolean productoFallback(int id, Throwable throwable) {
        log.error("Error al insertar el producto con id {}: {}", id, throwable.getMessage());
        return false;
    }
}
