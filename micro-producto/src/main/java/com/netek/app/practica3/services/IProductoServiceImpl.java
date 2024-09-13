package com.netek.app.practica3.services;

import com.netek.app.practica3.entities.Producto;
import com.netek.app.practica3.repository.IProductoDAO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class IProductoServiceImpl implements IProductoService {
    private final IProductoDAO dao;

    public IProductoServiceImpl(IProductoDAO dao) {
        this.dao = dao;
    }

    @Override
    public Producto save(Producto producto) {
        return dao.save(producto);
    }

    @Override
    public Boolean update(Producto producto) {
        if (dao.existsById(producto.getId())) {
            dao.save(producto);
            return true;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado " + producto.getId());
    }

    @Override
    public void deleteById(int id) {
        if (dao.existsById(id)) {
            dao.deleteById(id);
            return;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado " + id);
    }

    @Override
    public Producto findByName(String nombre) {
        /*        List<Producto> productos = dao.findByName(nombre);
        if (productos.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado: " + nombre);
        }
        return productos.get(0);*/
        return dao.findByName(nombre).get().stream().findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado: " + nombre));
    }

    @Override
    public Producto findById(int id) {
        return dao.findById(id).stream().findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "producto no encontrado" + id));
    }

    @Override
    public List<Producto> findAll() {
        Iterable<Producto> resultado = dao.findAll();
        return (List<Producto>) resultado;
    }
}
