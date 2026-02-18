package com.adrianhahn.gestioncomercial.dao;

import com.adrianhahn.gestioncomercial.model.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteDAO {

    void save(Cliente cliente);

    List<Cliente> findAll();

    Optional<Cliente> findById(Integer id);

    void update(Cliente cliente);

    void delete(Integer id);
}
