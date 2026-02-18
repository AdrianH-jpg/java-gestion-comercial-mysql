package com.adrianhahn.gestioncomercial.app;


import com.adrianhahn.gestioncomercial.model.Rol;
import com.adrianhahn.gestioncomercial.model.Usuario;
import com.adrianhahn.gestioncomercial.service.ClienteService;
import com.adrianhahn.gestioncomercial.service.ProductoService;

import java.math.BigDecimal;
import java.util.Scanner;

public class Menu {

    private final Usuario usuario;
    private final Scanner scanner;
    private final ClienteService clienteService;
    private final ProductoService productoService;

    public Menu(Usuario usuario){
        this.usuario = usuario;
        this.clienteService = new ClienteService();
        this.productoService = new ProductoService();
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
                case 2 -> menuProducto();
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
            System.out.println("3 - Actualizar Cliente");
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


    private void menuProducto(){

        int opcion;

        do {
            System.out.println("\n=== GESTIÓN PRODUCTO ===");
            System.out.println("1 - Crear Producto");
            System.out.println("2 - Listar Productos");
            System.out.println("3 - Actualizar Producto");
            System.out.println("4 - Eliminar Producto");
            System.out.println("0 - Volver");

            System.out.println("Seleccione una opcion: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch(opcion){
                case 1 -> createProducto();
                case 2 -> listProductos();
                case 3 -> updateProducto();
                case 4 -> deleteProducto();
                case 0 -> System.out.println("Volviendo....");
                default -> System.out.println("Opcion no valida");
            }
        }while (opcion != 0);
    }

    private void createProducto() {

        System.out.println("Codigo: ");
        String codigo = scanner.nextLine();

        System.out.println("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.println("Descripcion: ");
        String descipcion = scanner.nextLine();

        System.out.println("Precio: ");
        BigDecimal precio = new BigDecimal(scanner.nextLine());

        System.out.println("stock: ");
        Integer stock = Integer.parseInt(scanner.nextLine());

       productoService.createProducto(codigo,nombre,descipcion,precio,stock,true);
    }

    private void listProductos(){
        var productos = productoService.listProductos();

        if(productos.isEmpty()){
            System.out.println("No hay productos registrados");
            return;
        }

        for (var producto : productos){

            System.out.println("-----------------------------------------");
            System.out.println("ID: " + producto.getIdProducto());
            System.out.println("Nombre: " + producto.getNombre());
            System.out.println("Descripcion: " + producto.getDescripcion());
            System.out.println("Precio: " + producto.getPrecio());
            System.out.println("Stock: " + producto.getStock());
            System.out.println("Activo: " + producto.getActivo());
        }
    }

    private void updateProducto(){

        System.out.print("ID del producto a actualizar: ");
        Integer idProducto = Integer.parseInt(scanner.nextLine());

        var productoOptional = productoService.findById(idProducto);

        if(productoOptional.isEmpty()){
            System.out.println("El producto no existe");
            return;
        }

        var producto = productoOptional.get();

        System.out.print("Codigo: ");
        producto.setCodigo(scanner.nextLine());

        System.out.print("Nombre: ");
        producto.setNombre(scanner.nextLine());

        System.out.print("Decripcion: ");
        producto.setDescripcion(scanner.nextLine());

        System.out.print("Precio: ");
        producto.setPrecio(new BigDecimal(scanner.nextLine()));

        System.out.print("Stock: ");
        producto.setStock(Integer.parseInt(scanner.nextLine()));

        productoService.updateProducto(producto);
    }

    private void deleteProducto(){
        System.out.print("ID del Producto a eliminar: ");
        Integer idProducto = Integer.parseInt(scanner.nextLine());

        productoService.deleteProducto(idProducto);
    }
}
