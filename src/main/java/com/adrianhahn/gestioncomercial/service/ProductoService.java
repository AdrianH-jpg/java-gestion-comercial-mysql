package com.adrianhahn.gestioncomercial.service;

import com.adrianhahn.gestioncomercial.dao.ProductoDAO;
import com.adrianhahn.gestioncomercial.dao.ProductoDAOImpl;
import com.adrianhahn.gestioncomercial.model.Producto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class ProductoService {

    private final ProductoDAO productoDAO;

    public ProductoService() {
        this.productoDAO = new ProductoDAOImpl();
    }

    public void createProducto( String codigo, String nombre, String descripcion, BigDecimal precio, Integer stock, Boolean activo) {

        Producto producto = new Producto(codigo,nombre,descripcion,precio,stock,activo);
        productoDAO.save(producto);
    }

    public Optional<Producto> findById(Integer id) {
        return productoDAO.findById(id);
    }

    public List<Producto> listProductos() {
        return productoDAO.findAll();
    }

    public void updateProducto(Producto producto) {
        productoDAO.update(producto);
    }

    public void deleteProducto(Integer id) {
        productoDAO.delete(id);
    }
}
