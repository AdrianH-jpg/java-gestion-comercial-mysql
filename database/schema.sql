-- ==========================================
-- Creación de Base de Datos
-- ==========================================

CREATE DATABASE IF NOT EXISTS gestion_comercial_db;
USE gestion_comercial_db;

CREATE TABLE usuarios (
id_usuario INT AUTO_INCREMENT PRIMARY KEY,
username VARCHAR(50) NOT NULL UNIQUE,
password VARCHAR(100) NOT NULL,
rol ENUM('ADMIN','USER') NOT NULL,
activo BOOLEAN DEFAULT TRUE
);

CREATE TABLE clientes (
id_cliente INT AUTO_INCREMENT PRIMARY KEY,
nombre VARCHAR(100) NOT NULL,
apellido VARCHAR(100) NOT NULL,
dni VARCHAR(20) UNIQUE,
telefono VARCHAR(20),
email VARCHAR(100),
fechar_alta DATETIME DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE productos (
id_producto INT AUTO_INCREMENT PRIMARY KEY,
codigo VARCHAR(50) NOT NULL UNIQUE,
nombre VARCHAR(150) NOT NULL,
descripcion TEXT,
precio DECIMAL(10,2) NOT NULL,
stock INT NOT NULL DEFAULT 0,
activo BOOLEAN DEFAULT TRUE
);

CREATE TABLE ventas (
id_venta INT AUTO_INCREMENT PRIMARY KEY,
fecha DATETIME DEFAULT CURRENT_TIMESTAMP,
id_cliente INT NOT NULL,
id_usuario INT NOT NULL,
total DECIMAL(10,2) NOT NULL,
	CONSTRAINT fk_venta_cliente
		FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente),
	CONSTRAINT fk_venta_usuario
		FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario)
);


CREATE TABLE detalle_ventas (
id_detalle INT AUTO_INCREMENT PRIMARY KEY,
id_venta INT NOT NULL,
id_producto INT NOT NULL,
cantidad INT NOT NULL,
precio_unitario DECIMAL(10,2) NOT NULL,
subtotal DECIMAL(10,2) NOT NULL,
	CONSTRAINT fk_detalle_venta
		FOREIGN KEY (id_venta) REFERENCES ventas(id_venta),
	CONSTRAINT fk_detalle_producto
		FOREIGN KEY (id_producto) REFERENCES productos(id_producto)
);

INSERT INTO usuarios (username, password, rol)
VALUES ('admin','admin123','ADMIN');