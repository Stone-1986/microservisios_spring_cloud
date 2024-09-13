package com.netec.ms_carrito.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@Component
public class Carrito {
    private List<Producto> productos;

    public Carrito() {
        super();
        this.productos = new ArrayList<>();
    }
}
