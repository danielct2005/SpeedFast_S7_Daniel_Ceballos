package com.speedfast.view;
import com.speedfast.model.*;
import com.speedfast.dao.*;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class VentanaRegistroPedido extends JFrame {
    private JTextField txtDireccion;
    private JComboBox<String> cbTipo;
    private JComboBox<String> cbRepartidor; // Para listar repartidores de la BD
    private JButton btnGuardar;

    public VentanaRegistroPedido() {
        setTitle("Registrar Nuevo Pedido");
        setSize(400, 300);
        setLayout(new GridLayout(4, 2, 10, 10));

        add(new JLabel("Dirección:"));
        txtDireccion = new JTextField();
        add(txtDireccion);

        add(new JLabel("Tipo:"));
        cbTipo = new JComboBox<>(new String[]{"Comida", "Encomienda", "Express"});
        add(cbTipo);

        // --- Cargar Repartidores desde la BD ---
        add(new JLabel("Asignar Repartidor:"));
        cbRepartidor = new JComboBox<>();
        cargarRepartidores();
        add(cbRepartidor);

        btnGuardar = new JButton("Guardar en BD");
        add(btnGuardar);

        btnGuardar.addActionListener(e -> guardar());

        setLocationRelativeTo(null);
    }

    private void cargarRepartidores() {
        RepartidorDAO dao = new RepartidorDAO();
        List<Repartidor> lista = dao.listarTodos();
        for (Repartidor r : lista) {
            cbRepartidor.addItem(r.getNombre());
        }
    }

    private void guardar() {
        if (txtDireccion.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Complete la dirección");
            return;
        }

        Pedido p = new Pedido(
                txtDireccion.getText(),
                (String)cbTipo.getSelectedItem(),
                "PENDIENTE"
        );

        new PedidoDAO().guardar(p);
        JOptionPane.showMessageDialog(this, "Pedido guardado con éxito");
        dispose();
    }
}