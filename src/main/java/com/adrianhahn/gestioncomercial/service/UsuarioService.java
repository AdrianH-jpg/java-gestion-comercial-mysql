package com.adrianhahn.gestioncomercial.service;

import com.adrianhahn.gestioncomercial.dao.UsuarioDAO;
import com.adrianhahn.gestioncomercial.dao.UsuarioDAOImpl;
import com.adrianhahn.gestioncomercial.model.Usuario;

import java.util.Optional;

public class UsuarioService {

    private final UsuarioDAO usuarioDAO;

    public UsuarioService() {
        this.usuarioDAO = new UsuarioDAOImpl();
    }

    // Comparo texto plano, mas adelante cambiar por hash, no sear trolo

    public Optional<Usuario> login(String username, String password){
        Optional<Usuario> usuarioOptional = usuarioDAO.findByUsername(username);

        if(usuarioOptional.isEmpty()){
            return Optional.empty();
        }

        Usuario usuario = usuarioOptional.get();

        if(!usuario.getActivo()){
            return Optional.empty();
        }

        if(!usuario.getPassword().equals(password)){
            return Optional.empty();
        }
        return Optional.of(usuario);
    }

}
