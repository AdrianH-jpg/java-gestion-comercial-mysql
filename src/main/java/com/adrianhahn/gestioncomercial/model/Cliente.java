package com.adrianhahn.gestioncomercial.model;

import java.time.LocalDateTime;

public class Cliente {

    private Integer idCliente;
    private String nombre;
    private String apellido;
    private String dni;
    private String telefono;
    private String email;
    private LocalDateTime fechaAlta;


    public Cliente() {

    }

    public Cliente(String nombre, String apellido, String dni, String telefono, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.telefono = telefono;
        this.email = email;
        this.fechaAlta = LocalDateTime.now();
    }

    public Cliente(Integer idCliente, String nombre, String apellido, String dni, String telefono, String email, LocalDateTime fechaAlta) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.telefono = telefono;
        this.email = email;
        this.fechaAlta = fechaAlta;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDateTime fechaAlta) {
        this.fechaAlta = fechaAlta;
    }
}
