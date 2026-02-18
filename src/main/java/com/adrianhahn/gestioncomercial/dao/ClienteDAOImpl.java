package com.adrianhahn.gestioncomercial.dao;

import com.adrianhahn.gestioncomercial.model.Cliente;
import com.adrianhahn.gestioncomercial.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteDAOImpl implements ClienteDAO {

    @Override
    public void save(Cliente cliente) {

        String sql = "INSERT INTO clientes (nombre, apellido, dni, telefono, email) VALUES (?,?,?,?,?)";

        try (Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){

                preparedStatement.setString(1, cliente.getNombre());
                preparedStatement.setString(2, cliente.getApellido());
                preparedStatement.setString(3, cliente.getDni());
                preparedStatement.setString(4, cliente.getTelefono());
                preparedStatement.setString(5, cliente.getEmail());

                preparedStatement.executeUpdate();

            System.out.println("Cliente guardado correctamente");


        }catch (SQLException e) {
                e.printStackTrace();
        }

    }

    public List<Cliente> findAll(){

        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM clientes";

        try (Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery()){

            while (resultSet.next()){
                Cliente cliente = new Cliente(
                        resultSet.getInt("id_cliente"),
                        resultSet.getString("nombre"),
                        resultSet.getString("apellido"),
                        resultSet.getString("dni"),
                        resultSet.getString("telefono"),
                        resultSet.getString("email"),
                        resultSet.getTimestamp("fecha_alta").toLocalDateTime()
                );
                clientes.add(cliente);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return clientes;
    }

    @Override
    public Optional<Cliente> findById(Integer id) {

        String sql = "SELECT * FROM clientes WHERE id_cliente = ?";

        try (Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            preparedStatement.setInt(1,id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                Cliente cliente = new Cliente(
                        resultSet.getInt("id_cliente"),
                        resultSet.getString("nombre"),
                        resultSet.getString("apellido"),
                        resultSet.getString("dni"),
                        resultSet.getString("telefono"),
                        resultSet.getString("email"),
                        resultSet.getTimestamp("fecha_alta").toLocalDateTime()
                );
                return Optional.of(cliente);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return  Optional.empty();
    }

    @Override
    public void update(Cliente cliente) {

        String sql = "UPDATE clientes SET nombre=?, apellido=?, dni=?, telefono=?, email=? WHERE id_cliente = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement =  connection.prepareStatement(sql)){

            preparedStatement.setString(1,cliente.getNombre());
            preparedStatement.setString(2, cliente.getApellido());
            preparedStatement.setString(3, cliente.getDni());
            preparedStatement.setString(4, cliente.getTelefono());
            preparedStatement.setString(5, cliente.getEmail());
            preparedStatement.setInt(6,cliente.getIdCliente());

            preparedStatement.executeUpdate();

            System.out.println("Cliente actualizado correctamente");

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {

        String sql = "DELETE FROM clientes WHERE id_cliente = ?";

        try (Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();

            System.out.println("Cliente eliminado correctamente");

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
