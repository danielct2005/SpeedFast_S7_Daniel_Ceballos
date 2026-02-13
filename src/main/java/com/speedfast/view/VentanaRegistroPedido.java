package com.speedfast.view;
import com.speedfast.model.*;
import javax.swing.*;
import java.awt.*;

public class VentanaRegistroPedido extends JFrame {
    private JTextField txtId, txtDireccion;
    private JComboBox<String> cbTipo;
    private JButton btnGuardar;

    public VentanaRegistroPedido() {
        setTitle("Registrar Nuevo Pedido");
        setSize(300, 250);
        setLayout(new GridLayout(4, 2, 10, 10));

        add(new JLabel("ID Pedido:"));
        txtId = new JTextField();
        add(txtId);

        add(new JLabel("Dirección:"));
        txtDireccion = new JTextField();
        add(txtDireccion);

        add(new JLabel("Tipo:"));
        String[] tipos = {"Comida", "Encomienda", "Express"};
        cbTipo = new JComboBox<>(tipos);
        add(cbTipo);

        btnGuardar = new JButton("Guardar");
        add(btnGuardar);

        btnGuardar.addActionListener(e -> guardar());

        setLocationRelativeTo(null); // Centrar ventana
    }

    private void guardar() {
        if (txtId.getText().isEmpty() || txtDireccion.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor complete todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Pedido nuevo = new Pedido(txtId.getText(), txtDireccion.getText(), (String) cbTipo.getSelectedItem());
        ControladorDatos.getInstance().agregarPedido(nuevo);

        JOptionPane.showMessageDialog(this, "Pedido registrado con éxito");
        dispose(); // Cerrar ventana al terminar
    }
}