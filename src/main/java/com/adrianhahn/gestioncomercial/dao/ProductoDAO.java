package com.adrianhahn.gestioncomercial.dao;

import com.adrianhahn.gestioncomercial.model.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoDAO {

    void save(Producto producto);

    Optional<Producto> findById(Integer id);


    List<Producto> findAll();

    void update(Producto producto);

    void delete(Integer id);
}
