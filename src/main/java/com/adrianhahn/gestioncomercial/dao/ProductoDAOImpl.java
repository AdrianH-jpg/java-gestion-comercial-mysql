package com.adrianhahn.gestioncomercial.dao;

import com.adrianhahn.gestioncomercial.model.Producto;
import com.adrianhahn.gestioncomercial.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductoDAOImpl implements ProductoDAO {

    @Override
    public void save(Producto producto) {

        String sql = "INSERT INTO productos (codigo, nombre, descripcion, precio, stock, activo) VALUES (?,?,?,?,?,?)";

        try (Connection connection = DatabaseConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            preparedStatement.setString(1,producto.getCodigo());
            preparedStatement.setString(2,producto.getNombre());
            preparedStatement.setString(3, producto.getDescripcion());
            preparedStatement.setBigDecimal(4, producto.getPrecio());
            preparedStatement.setInt(5,producto.getStock());
            preparedStatement.setBoolean(6,producto.getActivo());

            preparedStatement.executeUpdate();

            System.out.println("Producto guardado correctamente");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Producto> findAll(){

        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT * FROM productos";

        try (Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Producto producto = new Producto(
                        resultSet.getInt("id_producto"),
                        resultSet.getString("codigo"),
                        resultSet.getString("nombre"),
                        resultSet.getString("descripcion"),
                        resultSet.getBigDecimal("precio"),
                        resultSet.getInt("stock"),
                        resultSet.getBoolean("activo")
                );

                productos.add(producto);
            }
        }catch (SQLException e){
                e.printStackTrace();
        }
        return productos;
    }

    @Override
    public Optional<Producto> findById(Integer id){

        String sql = "SELECT * FROM productos WHERE id_producto = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Producto producto = new Producto(
                        resultSet.getInt("id_producto"),
                        resultSet.getString("codigo"),
                        resultSet.getString("nombre"),
                        resultSet.getString("descipcion"),
                        resultSet.getBigDecimal("precio"),
                        resultSet.getInt("stock"),
                        resultSet.getBoolean("activo")
                );
                return Optional.of(producto);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void update(Producto producto) {

        String sql = "UPDATE productos SET codigo=?, nombre=?, descripcion=?,precio=?, stock=?, activo=? WHERE id_producto = ?";

        try (Connection connection = DatabaseConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            preparedStatement.setString(1, producto.getCodigo());
            preparedStatement.setString(2, producto.getNombre());
            preparedStatement.setString(3, producto.getDescripcion());
            preparedStatement.setBigDecimal(4, producto.getPrecio());
            preparedStatement.setInt(5, producto.getStock());
            preparedStatement.setBoolean(6, producto.getActivo());
            preparedStatement.setInt(7, producto.getIdProducto());

            preparedStatement.executeUpdate();
            System.out.println("Producto actualizado correctamente");

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM productos WHERE id_producto = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();

            System.out.println("Producto eliminado correctamente");

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
