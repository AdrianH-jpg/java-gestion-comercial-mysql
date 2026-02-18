package com.adrianhahn.gestioncomercial.app;

import com.adrianhahn.gestioncomercial.model.Rol;
import com.adrianhahn.gestioncomercial.model.Usuario;

import java.util.Scanner;

public class Menu {

    private final Usuario usuario;
    private final Scanner scanner;

    public Menu(Usuario usuario){
        this.usuario = usuario;
        this.scanner = new Scanner(System.in);
    }

    public void iniciar(){
        if(usuario.getRol() == Rol.ADMIN){
            menuAdmin();
        }else{
            menuUser();
        }
    }

    private void menuAdmin(){

        int opcion;

        do{
            System.out.println("\n=== MENU ADMIN ===");
            System.out.println("1 - Gestionar Clientes");
            System.out.println("2 - Gestionar Productos");
            System.out.println("3 - Registrar Venta");
            System.out.println("0 - Salir");

            System.out.print("Seleccione una opción: ");

            opcion = Integer.parseInt(scanner.nextLine());

            switch(opcion){
                case 1 -> System.out.println("Módulo Clientes (pendiente)");
                case 2 -> System.out.println("Módulo Productos (pendiente)");
                case 3 -> System.out.println("Módulo Ventas (pendiente)");
                case 0 -> System.out.println("Saliendo....");
                default -> System.out.println("Opcion no valida");
            }
        }while(opcion != 0);
    }

    private void menuUser(){

        int opcion;

        do {
            System.out.println("\n=== MENU USER ===");
            System.out.println("1 - Registrar Venta");
            System.out.println("0 - Salir");

            System.out.print("Seleccione una opción: ");
            opcion = Integer.parseInt(scanner.nextLine());
            switch(opcion){
                case 1 -> System.out.println("Módulo Ventas (pendiente)");
                case 0 -> System.out.println("Saliendo....");
                default -> System.out.println("Opcion no valida");
            }
        }while(opcion != 0);
    }
}
