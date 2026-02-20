package com.speedfast.view;
import com.speedfast.model.Pedido;
import com.speedfast.dao.PedidoDAO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VentanaListaPedidos extends JFrame {
    private JTable tabla;
    private DefaultTableModel modelo;

    public VentanaListaPedidos() {
        setTitle("Pedidos desde Base de Datos");
        setSize(500, 300);
        setLayout(new BorderLayout());

        modelo = new DefaultTableModel(new String[]{"ID", "Dirección", "Tipo", "Estado"}, 0);
        tabla = new JTable(modelo);
        cargarDesdeBD();

        add(new JScrollPane(tabla), BorderLayout.CENTER);

        JButton btnRefrescar = new JButton("Actualizar");
        btnRefrescar.addActionListener(e -> cargarDesdeBD());
        add(btnRefrescar, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
    }

    private void cargarDesdeBD() {
        modelo.setRowCount(0);
        for (Pedido p : new PedidoDAO().listar()) {
            modelo.addRow(new Object[]{p.getId(), p.getDireccion(), p.getTipo(), p.getEstado()});
        }
    }
}