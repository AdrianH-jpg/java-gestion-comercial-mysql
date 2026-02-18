package com.adrianhahn.gestioncomercial.service;

import com.adrianhahn.gestioncomercial.dao.ClienteDAO;
import com.adrianhahn.gestioncomercial.dao.ClienteDAOImpl;
import com.adrianhahn.gestioncomercial.model.Cliente;

import java.util.List;
import java.util.Optional;

public class ClienteService {

    private final ClienteDAO clienteDAO;

    public ClienteService() {
        this.clienteDAO = new ClienteDAOImpl();
    }

    public void createCliente(String nombre, String apellido, String dni, String telefono, String email) {

        Cliente cliente = new Cliente(nombre, apellido, dni, telefono, email);

        clienteDAO.save(cliente);
    }

    public List<Cliente> listClientes() {

        return clienteDAO.findAll();
    }

    public void  updateCliente(Cliente cliente) {
        clienteDAO.update(cliente);
    }

    public void deleteCliente(Integer id) {
        clienteDAO.delete(id);
    }

    public Optional<Cliente> findClienteById(Integer id) {
        return clienteDAO.findById(id);
    }


}
