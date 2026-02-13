package com.speedfast.view;
import com.speedfast.model.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VentanaListaPedidos extends JFrame {
    private JTable tabla;
    private DefaultTableModel modelo;

    public VentanaListaPedidos() {
        setTitle("Lista de Pedidos");
        setSize(500, 300);
        setLayout(new BorderLayout());

        String[] columnas = {"ID", "Dirección", "Tipo"};
        modelo = new DefaultTableModel(columnas, 0);
        tabla = new JTable(modelo);

        cargarDatos();

        add(new JScrollPane(tabla), BorderLayout.CENTER);

        JButton btnRefrescar = new JButton("Refrescar");
        btnRefrescar.addActionListener(e -> cargarDatos());
        add(btnRefrescar, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
    }

    private void cargarDatos() {
        modelo.setRowCount(0); // Limpiar tabla
        for (Pedido p : ControladorDatos.getInstance().getListaPedidos()) {
            Object[] fila = {p.getId(), p.getDireccion(), p.getTipo()};
            modelo.addRow(fila);
        }
    }
}