package ticTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Principal extends JFrame {
	
    public Principal() {
        initializeUI();
    }

    private void initializeUI() {
        // Configuración de la ventana principal
        setTitle("Menú Principal");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel principal con BoxLayout
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        // Panel superior para el texto "Tres en Raya"
        JPanel topPanel = new JPanel();
        JLabel titleLabel = new JLabel("Tres en Raya");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        topPanel.add(titleLabel);

        // Panel central con los botones de nueva partida y cargar partida
        JPanel centerPanel = new JPanel(new GridLayout(2, 2));

        // Botón "Un Jugador"
        JButton unJugadorButton = new JButton("Nuava Partida Un Jugador");
        unJugadorButton.setBackground(Color.BLACK);
        unJugadorButton.setForeground(Color.WHITE);
        unJugadorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TresEnRaya game = new TresEnRaya();
                game.setVisible(true);
                setVisible(false);
            }
        });
        centerPanel.add(unJugadorButton);

        // Botón "Dos Jugadores"
        JButton dosJugadoresButton = new JButton("Nueva Partida Dos Jugadores");
        dosJugadoresButton.setBackground(Color.BLACK);
        dosJugadoresButton.setForeground(Color.WHITE);
        dosJugadoresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TresEnRaya1v1 game1v1 = new TresEnRaya1v1();
                game1v1.setVisible(true);
                setVisible(false);
            }
        });
        centerPanel.add(dosJugadoresButton);

        // Botón "Cargar Partida" (Un Jugador)
        JButton cargarPartidaButton = new JButton("Cargar Partida Un Jugador");
        cargarPartidaButton.setBackground(Color.BLACK);
        cargarPartidaButton.setForeground(Color.WHITE);
        cargarPartidaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TresEnRaya game = new TresEnRaya();
                game.loadGame("game_save.ser");
                game.setVisible(true);
                setVisible(false);
            }
        });
        centerPanel.add(cargarPartidaButton);
        
        // Botón "Cargar Partida" (Dos Jugadores)
        JButton cargarPartidaButton1v1 = new JButton("Cargar Partida Dos Jugadores");
        cargarPartidaButton1v1.setBackground(Color.BLACK);
        cargarPartidaButton1v1.setForeground(Color.WHITE);
        cargarPartidaButton1v1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TresEnRaya1v1 game = new TresEnRaya1v1();
                game.loadGame("game_save1v1.ser");
                game.setVisible(true);
                setVisible(false);
            }
        });
        centerPanel.add(cargarPartidaButton1v1);

        // Agregar paneles al panel principal
        mainPanel.add(Box.createVerticalGlue());  // Espaciado para centrar verticalmente
        mainPanel.add(topPanel);
        mainPanel.add(centerPanel);
        mainPanel.add(Box.createVerticalGlue());  // Espaciado para centrar verticalmente

        add(mainPanel);
    }
    
    // Método principal
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Principal menu = new Principal();
            menu.setVisible(true);
        });
    }
}
