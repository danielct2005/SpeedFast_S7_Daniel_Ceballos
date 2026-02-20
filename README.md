# SpeedFast - Gestión de Entregas (Semana 7)

Este proyecto es una aplicación de escritorio desarrollada en **Java Swing** para la empresa **SpeedFast**, enfocada en la gestión de pedidos y entregas. En esta etapa, se ha implementado la persistencia de datos utilizando **JDBC** y **MySQL**.

## 🚀 Características
* **Conexión JDBC**: Clase `ConexionDB` con manejo de excepciones para el enlace con MySQL.
* **Patrón DAO**: Implementación de `PedidoDAO`, `RepartidorDAO` y `EntregaDAO` para la gestión de datos.
* **Persistencia Real**: Almacenamiento de pedidos, repartidores y la relación de entregas en base de datos.
* **Interfaz Gráfica**: Ventanas integradas con componentes dinámicos que consumen datos de la BD.

## 🛠️ Requisitos Técnicos
* **IDE**: IntelliJ IDEA.
* **Base de Datos**: MySQL Workbench.
* **Driver**: MySQL Connector/J (incluido en la carpeta `/lib`).
* **JDK**: 17 o superior.

## 📋 Configuración de la Base de Datos
Para el correcto funcionamiento, se debe crear la base de datos `speedfast_db`. Script SQL utilizado:

```sql
CREATE DATABASE IF NOT EXISTS speedfast_db;
USE speedfast_db;

CREATE TABLE repartidor (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL
);

CREATE TABLE pedido (
    id INT AUTO_INCREMENT PRIMARY KEY,
    direccion VARCHAR(150) NOT NULL,
    tipo VARCHAR(30) NOT NULL,
    estado VARCHAR(20) NOT NULL
);

CREATE TABLE entrega (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_pedido INT,
    id_repartidor INT,
    fecha DATE,
    hora TIME,
    FOREIGN KEY (id_pedido) REFERENCES pedido(id),
    FOREIGN KEY (id_repartidor) REFERENCES repartidor(id)
);
📁 Estructura del Proyecto
com.speedfast.dao: Gestión de conexión y operaciones CRUD.

com.speedfast.model: Entidades del sistema (Pedido, Repartidor).

com.speedfast.view: Interfaz gráfica de usuario.

lib: Driver JDBC para MySQL.

✍️ Autor
Daniel Ceballos
