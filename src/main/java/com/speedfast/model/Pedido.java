package com.speedfast.model;

public class Pedido {
    private int id; // Cambiado a int para la BD
    private String direccion;
    private String tipo;
    private String estado;

    // Constructor para nuevos pedidos (ID lo da la BD)
    public Pedido(String direccion, String tipo, String estado) {
        this.direccion = direccion;
        this.tipo = tipo;
        this.estado = estado;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getDireccion() { return direccion; }
    public String getTipo() { return tipo; }
    public String getEstado() { return estado; }
}