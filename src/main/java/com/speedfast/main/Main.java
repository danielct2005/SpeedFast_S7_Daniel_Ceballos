package com.speedfast.main;
import com.speedfast.view.VentanaPrincipal;

public class Main {
    public static void main(String[] args) {
        // Ejecutar en el hilo de despacho de eventos de Swing por seguridad
        javax.swing.SwingUtilities.invokeLater(() -> {
            new VentanaPrincipal().setVisible(true);
        });
    }
}