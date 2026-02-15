package com.adrianhahn.gestioncomercial.dao;

import com.adrianhahn.gestioncomercial.model.Rol;
import com.adrianhahn.gestioncomercial.model.Usuario;
import com.adrianhahn.gestioncomercial.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class UsuarioDAOImpl implements UsuarioDAO {

    @Override
    public Optional<Usuario> findByUsername(String username){
        String sql = "SELECT * FROM usuarios WHERE username = ?";

        try (Connection connection = DatabaseConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            preparedStatement.setString(1,username);
            ResultSet resultSet = preparedStatement.executeQuery();

           if(resultSet.next()) {
               Usuario usuario = new Usuario(
                       resultSet.getInt("id_usuario"),
                       resultSet.getString("username"),
                       resultSet.getString("password"),
                       Rol.valueOf(resultSet.getString("rol")),
                       resultSet.getBoolean("activo")
               );
               return Optional.of(usuario);
           }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
