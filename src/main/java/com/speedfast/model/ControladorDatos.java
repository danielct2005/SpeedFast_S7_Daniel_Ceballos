package com.speedfast.model;
import java.util.ArrayList;
import java.util.List;

public class ControladorDatos {
    private static ControladorDatos instance;
    private List<Pedido> listaPedidos;

    private ControladorDatos() {
        listaPedidos = new ArrayList<>();
    }

    public static ControladorDatos getInstance() {
        if (instance == null) instance = new ControladorDatos();
        return instance;
    }

    public void agregarPedido(Pedido p) { listaPedidos.add(p); }
    public List<Pedido> getListaPedidos() { return listaPedidos; }
}