package com.netec.ms_carrito.feing;

import com.netec.ms_carrito.entities.Producto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "micro-producto")
public interface IArticuloFeign {
    @GetMapping("/productos/{id}")
    Producto findById(@PathVariable("id") int id);
}
