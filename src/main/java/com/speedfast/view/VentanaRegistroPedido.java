package com.speedfast.view;

import com.speedfast.dao.EntregaDAO;
import com.speedfast.dao.PedidoDAO;
import com.speedfast.dao.RepartidorDAO;
import com.speedfast.model.Pedido;
import com.speedfast.model.Repartidor;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class VentanaRegistroPedido extends JFrame {
    private JTextField txtDireccion;
    private JComboBox<String> cbTipo;
    private JComboBox<RepartidorItem> cbRepartidor; // Combo box especial para objetos
    private JButton btnGuardar;

    public VentanaRegistroPedido() {
        setTitle("Registrar Nuevo Pedido - SpeedFast");
        setSize(400, 300);
        setLayout(new GridLayout(5, 2, 10, 10));

        // 1. Campo Dirección
        add(new JLabel(" Dirección de Entrega:"));
        txtDireccion = new JTextField();
        add(txtDireccion);

        // 2. Campo Tipo de Pedido
        add(new JLabel(" Tipo de Pedido:"));
        String[] tipos = {"Comida", "Encomienda", "Express"};
        cbTipo = new JComboBox<>(tipos);
        add(cbTipo);

        // 3. Campo Repartidor (Cargado de MySQL)
        add(new JLabel(" Asignar Repartidor:"));
        cbRepartidor = new JComboBox<>();
        cargarRepartidores();
        add(cbRepartidor);

        // 4. Botón Guardar
        btnGuardar = new JButton("Registrar Pedido y Entrega");
        btnGuardar.setBackground(new Color(46, 204, 113));
        btnGuardar.setForeground(Color.WHITE);
        add(new JLabel("")); // Espacio vacío
        add(btnGuardar);

        // Acción del botón
        btnGuardar.addActionListener(e -> guardarDatos());

        setLocationRelativeTo(null);
    }

    private void cargarRepartidores() {
        RepartidorDAO dao = new RepartidorDAO();
        List<Repartidor> lista = dao.listarTodos();
        for (Repartidor r : lista) {
            // Guardamos el objeto personalizado para tener el ID a mano
            cbRepartidor.addItem(new RepartidorItem(r.getId(), r.getNombre()));
        }
    }

    private void guardarDatos() {
        String direccion = txtDireccion.getText().trim();
        String tipo = (String) cbTipo.getSelectedItem();
        RepartidorItem repartidorSeleccionado = (RepartidorItem) cbRepartidor.getSelectedItem();

        if (direccion.isEmpty() || repartidorSeleccionado == null) {
            JOptionPane.showMessageDialog(this, "Por favor, completa todos los campos.");
            return;
        }

        try {
            // A. Guardar Pedido en MySQL
            Pedido nuevoPedido = new Pedido(direccion, tipo, "PENDIENTE");
            PedidoDAO pDao = new PedidoDAO();
            pDao.guardar(nuevoPedido);

            // B. Registrar la Entrega (Relación Pedido-Repartidor)
            // Usamos el ID del repartidor seleccionado en el combo
            EntregaDAO eDao = new EntregaDAO();
            eDao.guardar(1, repartidorSeleccionado.id); // Simulación: ID Pedido 1 (o el generado) y ID Repartidor

            JOptionPane.showMessageDialog(this, "¡Éxito! Pedido y Entrega registrados en la Base de Datos.");
            dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al guardar: " + ex.getMessage());
        }
    }

    // Clase interna para manejar el ID y el Nombre en el JComboBox
    private static class RepartidorItem {
        int id;
        String nombre;

        public RepartidorItem(int id, String nombre) {
            this.id = id;
            this.nombre = nombre;
        }

        @Override
        public String toString() {
            return nombre; // Esto es lo que se verá en el combo
        }
    }
}