package com.adrianhahn.gestioncomercial.dao;

import com.adrianhahn.gestioncomercial.model.Usuario;

import java.util.Optional;

public interface UsuarioDAO {
    Optional<Usuario> findByUsername(String username);
}
