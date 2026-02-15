# 🏪 Sistema de Gestión Comercial

Backend desarrollado con Java 22, Maven y MySQL.

------------------------------------------------------------------------

## 📌 Descripción del Proyecto

Este proyecto consiste en el desarrollo de un **Sistema de Gestión
Comercial**, construido desde cero, documentando cada etapa del proceso
de desarrollo.

El objetivo es demostrar:

-   Diseño de casos de uso
-   Modelado de base de datos
-   Arquitectura en capas
-   Conexión a base de datos con JDBC
-   Implementación de DAO y Services
-   Buenas prácticas en organización del código

El proyecto forma parte de una serie donde se muestra el desarrollo paso
a paso.

------------------------------------------------------------------------

## 🛠 Tecnologías Utilizadas

-   Java 22
-   Maven
-   MySQL
-   JDBC

------------------------------------------------------------------------

## 🏗 Arquitectura del Proyecto

El sistema está estructurado en capas:

    com.adrian.gestioncomercial
    │
    ├── app        → Clase principal
    ├── model      → Entidades del sistema
    ├── dao        → Acceso a datos
    ├── service    → Lógica de negocio
    └── util       → Conexión a base de datos

Esta estructura permite mantener separación de responsabilidades y
escalabilidad futura.

------------------------------------------------------------------------

## 📊 Funcionalidades Iniciales

-   Gestión de Usuarios
-   Gestión de Productos
-   Gestión de Clientes
-   Control de roles (ADMIN / USER)
-   Conexión a base de datos validada

------------------------------------------------------------------------

## 🗄 Base de Datos

El script de creación se encuentra en:

    database/schema.sql

Incluye:

-   Creación de base de datos
-   Creación de tablas
-   Relaciones
-   Inserción de usuario administrador inicial

------------------------------------------------------------------------

## ▶ Cómo Ejecutar el Proyecto

1️⃣ Clonar el repositorio\
2️⃣ Ejecutar el script `schema.sql` en MySQL\
3️⃣ Configurar credenciales en la clase de conexión\
4️⃣ Ejecutar la clase `main`

------------------------------------------------------------------------

## 🔐 Nota de Seguridad

Actualmente las credenciales están configuradas de forma simple para
pruebas de desarrollo.\
En próximas versiones se implementará externalización de configuración y
mejoras de seguridad.

------------------------------------------------------------------------

## 🚀 Estado del Proyecto

En desarrollo -- Serie documentada paso a paso.

------------------------------------------------------------------------

## 👨‍💻 Autor

**Adrian Hahn**\
Backend Developer -- Java
