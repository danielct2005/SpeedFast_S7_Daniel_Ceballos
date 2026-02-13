package com.speedfast.model;

public class Pedido {
    private String id;
    private String direccion;
    private String tipo; // Comida, Encomienda, Express

    // Constructor
    public Pedido(String id, String direccion, String tipo) {
        this.id = id;
        this.direccion = direccion;
        this.tipo = tipo;
    }

    // Getters y Setters (Necesarios para que el JTable y el Controlador lean los datos)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    // Opcional: Para depuración en consola
    @Override
    public String toString() {
        return "Pedido{" + "id='" + id + '\'' + ", direccion='" + direccion + '\'' + ", tipo='" + tipo + '\'' + '}';
    }
}