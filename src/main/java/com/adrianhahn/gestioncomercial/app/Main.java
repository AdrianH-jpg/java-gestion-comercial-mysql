package com.adrianhahn.gestioncomercial.app;

import com.adrianhahn.gestioncomercial.model.Usuario;
import com.adrianhahn.gestioncomercial.service.UsuarioService;
import com.adrianhahn.gestioncomercial.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

       Scanner scanner = new Scanner(System.in);
        UsuarioService usuarioService = new UsuarioService();

        System.out.println("=== SISTEMA DE GESTIÓN COMERCIAL ===");

        System.out.print("Usuario: ");
        String username = scanner.nextLine();

        System.out.print("Contraseña: ");
        String password = scanner.nextLine();

        Optional<Usuario> usuario = usuarioService.login(username,password);
        if (usuario.isPresent()) {
            System.out.println("Login exitoso ");
            System.out.println("Bienvenido " + usuario.get().getUsername());
        }else {
            System.out.println("Credenciales incorrectos");
        }

        scanner.close();
        // Siempre cerrar el scanner, no seas trolooooooo
    }
}