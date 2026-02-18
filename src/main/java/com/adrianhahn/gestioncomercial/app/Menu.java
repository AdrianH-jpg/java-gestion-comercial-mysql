package com.adrianhahn.gestioncomercial.app;


import com.adrianhahn.gestioncomercial.model.Rol;
import com.adrianhahn.gestioncomercial.model.Usuario;
import com.adrianhahn.gestioncomercial.service.ClienteService;

import java.util.Scanner;

public class Menu {

    private final Usuario usuario;
    private final Scanner scanner;
    private final ClienteService clienteService;

    public Menu(Usuario usuario){
        this.usuario = usuario;
        this.clienteService = new ClienteService();
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
                case 1 -> menuClientes();
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

    private void menuClientes(){

        int opcion;

        do {
            System.out.println("\n=== GESTIÓN CLIENTES ===");
            System.out.println("1 - Crear Cliente");
            System.out.println("2 - Listar Clientes");
            System.out.println("3 - Actuaño Cliente");
            System.out.println("4 - Eliminar Cliente");
            System.out.println("0 - Volver");

            System.out.println("Seleccione una opcion: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch(opcion){
                case 1 -> createCliente();
                case 2 -> listClientes();
                case 3 -> updateCliente();
                case 4 -> deleteCliente();
                case 0 -> System.out.println("Volviendo....");
                default -> System.out.println("Opcion no valida");
            }
        }while (opcion != 0);
    }

    private void createCliente() {

        System.out.println("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.println("Apellido: ");
        String apellido = scanner.nextLine();

        System.out.println("DNI: ");
        String dni = scanner.nextLine();

        System.out.println("Telefono: ");
        String telefono = scanner.nextLine();

        System.out.println("Email: ");
        String email = scanner.nextLine();

        clienteService.createCliente(nombre, apellido, dni, telefono, email);
    }

    private void listClientes(){

        var clientes = clienteService.listClientes();

        if(clientes.isEmpty()){
            System.out.println("No hay clientes registrados");
            return;
        }

        for (var cliente : clientes){
            System.out.println("-------------------------------------------");
            System.out.println("ID: " + cliente.getIdCliente());
            System.out.println("Nombre: " + cliente.getNombre());
            System.out.println("Apellido: " + cliente.getApellido());
            System.out.println("DNI: " + cliente.getDni());
            System.out.println("Telefono: " + cliente.getTelefono());
            System.out.println("Email: " + cliente.getEmail());
            System.out.println("Fecha Alta: " + cliente.getFechaAlta());
        }
    }

    private void updateCliente(){

        System.out.print("ID del cliente a actualizar: ");
        Integer idCliente = Integer.parseInt(scanner.nextLine());

        var clienteOptional = clienteService.findClienteById(idCliente);

        if(clienteOptional.isEmpty()){
            System.out.println("El cliente no existe");
            return;
        }

        var cliente = clienteOptional.get();

        System.out.print("Nombre: ");
        cliente.setNombre(scanner.nextLine());

        System.out.print("Apellido: ");
        cliente.setApellido(scanner.nextLine());

        System.out.print("DNI: ");
        cliente.setDni(scanner.nextLine());

        System.out.print("Telefono: ");
        cliente.setTelefono(scanner.nextLine());

        System.out.print("Email: ");
        cliente.setEmail(scanner.nextLine());

        clienteService.updateCliente(cliente);
    }

    private void deleteCliente(){
        System.out.print("ID del cliente a eliminar: ");
        Integer idCliente = Integer.parseInt(scanner.nextLine());

        clienteService.deleteCliente(idCliente);
    }
}
