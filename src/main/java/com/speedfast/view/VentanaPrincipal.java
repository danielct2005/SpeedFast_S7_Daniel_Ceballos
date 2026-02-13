package com.speedfast.view;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {
    public VentanaPrincipal() {
        setTitle("SpeedFast - Gestión de Entregas");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Título superior
        JLabel lblTitulo = new JLabel("Sistema SpeedFast", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        add(lblTitulo, BorderLayout.NORTH);

        // Panel central para botones
        JPanel panelBotones = new JPanel(new GridLayout(3, 1, 10, 10));
        panelBotones.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        JButton btnRegistro = new JButton("Registrar Pedido");
        JButton btnLista = new JButton("Ver Pedidos");
        JButton btnEntregas = new JButton("Gestionar Entregas (Simular)");

        // Programación de navegación
        btnRegistro.addActionListener(e -> new VentanaRegistroPedido().setVisible(true));
        btnLista.addActionListener(e -> new VentanaListaPedidos().setVisible(true));

        // El botón btnEntregas se queda como "fantasma" (sin listener)
        // Solo cumple la función estética y de diseño requerida.

        panelBotones.add(btnRegistro);
        panelBotones.add(btnLista);
        panelBotones.add(btnEntregas);

        add(panelBotones, BorderLayout.CENTER);

        // Centrar en pantalla
        setLocationRelativeTo(null);
    }
}