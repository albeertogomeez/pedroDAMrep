package ticTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TresEnRaya extends JFrame {

    private JButton[][] buttons;
    private char[][] board;
    private char currentPlayer;
    
    // Constructor de la clase
    public TresEnRaya() {
        buttons = new JButton[3][3];
        board = new char[3][3];
        currentPlayer = 'X';

        initializeBoard();
        initializeUI();
    }

    // Inicializa el tablero con espacios en blanco
    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    // Inicializa la interfaz de usuario
    private void initializeUI() {
        setTitle("Tres en Raya");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel principal que contiene el tablero y los controles
        JPanel gamePanel = new JPanel(new GridLayout(3, 3, 10, 10));
        gamePanel.setBackground(Color.BLACK);

        // Crear y configurar botones del tablero
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setBackground(Color.GRAY);
                buttons[i][j].setForeground(Color.WHITE);
                Font font = new Font(buttons[i][j].getFont().getName(), Font.PLAIN, 75);
                buttons[i][j].setFont(font);
                buttons[i][j].setFocusPainted(false);
                buttons[i][j].addActionListener(new ButtonClickListener(i, j));
                gamePanel.add(buttons[i][j]);
            }
        }

        // Panel de control con botones de reinicio y guardar
        JPanel controlPanel = new JPanel(new GridLayout(2, 1));

        JButton restartButton = new JButton("Reiniciar");
        restartButton.setBackground(Color.WHITE);
        restartButton.setForeground(Color.BLACK);
        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetGame();
            }

            private void resetGame() {
                initializeBoard();
                currentPlayer = 'X';

                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        buttons[i][j].setText("");
                    }
                }
            }
        });

        JButton guardar = new JButton("Guardar");
        guardar.setBackground(Color.WHITE);
        guardar.setForeground(Color.BLACK);
        guardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveGame("game_save.ser");
            }
        });

        controlPanel.add(restartButton);
        controlPanel.add(guardar);

        // Agregar componentes al marco principal
        add(gamePanel, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);
    }
    
    // Método para guardar la partida
    public void saveGame(String filename) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            GameState gameState = new GameState(board, currentPlayer);
            outputStream.writeObject(gameState);
            System.out.println("Partida guardada correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Clase interna que maneja los eventos de clic en los botones del tablero
    private class ButtonClickListener implements ActionListener {
        private int row, col;

        // Constructor de la clase interna
        public ButtonClickListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        // Método invocado cuando se hace clic en un botón del tablero
        @Override
        public void actionPerformed(ActionEvent e) {
            if (board[row][col] == ' ' && currentPlayer == 'X') {
                buttons[row][col].setText("X");
                board[row][col] = 'X';

                if (checkWin('X')) {
                    JOptionPane.showMessageDialog(null, "¡Felicidades! Has ganado.");
                    resetGame();
                } else if (isBoardFull()) {
                    JOptionPane.showMessageDialog(null, "¡Es un empate!");
                    resetGame();
                } else {
                    currentPlayer = 'O';
                    makeComputerMove();
                }
            }
        }
    }

    // Método para verificar si hay un ganador
    private boolean checkWin(char symbol) {
        // Verifica filas y columnas
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) ||
                    (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol)) {
                return true;
            }
        }

        // Verifica diagonales
        return (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) ||
                (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol);
    }

    // Método para verificar si el tablero está lleno
    private boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    // Método para realizar el movimiento de la consola
    private void makeComputerMove() {
        int[] bestMove = getBestMove();
        int row = bestMove[0];
        int col = bestMove[1];

        buttons[row][col].setText("O");
        board[row][col] = 'O';

        if (checkWin('O')) {
            JOptionPane.showMessageDialog(null, "¡La consola ha ganado!");
            resetGame();
        } else if (isBoardFull()) {
            JOptionPane.showMessageDialog(null, "¡Es un empate!");
            resetGame();
        }

        currentPlayer = 'X';
    }

    // Método para obtener el mejor movimiento para la consola usando el algoritmo minimax
    private int[] getBestMove() {
        int[] bestMove = new int[]{-1, -1};
        int bestScore = Integer.MIN_VALUE;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    board[i][j] = 'O';
                    int score = minimax(board, 0, false);
                    board[i][j] = ' ';

                    if (score > bestScore) {
                        bestScore = score;
                        bestMove[0] = i;
                        bestMove[1] = j;
                    }
                }
            }
        }

        return bestMove;
    }

    // Algoritmo minimax para evaluar el estado del tablero
    private int minimax(char[][] board, int depth, boolean isMaximizing) {
        if (checkWin('X')) {
            return -1;
        } else if (checkWin('O')) {
            return 1;
        } else if (isBoardFull()) {
            return 0;
        }

        if (isMaximizing) {
            int bestScore = Integer.MIN_VALUE;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == ' ') {
                        board[i][j] = 'O';
                        int score = minimax(board, depth + 1, false);
                        board[i][j] = ' ';
                        bestScore = Math.max(score, bestScore);
                    }
                }
            }

            return bestScore;
        } else {
            int bestScore = Integer.MAX_VALUE;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == ' ') {
                        board[i][j] = 'X';
                        int score = minimax(board, depth + 1, true);
                        board[i][j] = ' ';
                        bestScore = Math.min(score, bestScore);
                    }
                }
            }

            return bestScore;
        }
    }

    // Método para reiniciar el juego
    public void resetGame() {
        initializeBoard();
        currentPlayer = 'X';

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
            }
        }
    }

    // Método para cargar una partida guardada desde un archivo
    public void loadGame(String filename) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filename))) {
            GameState gameState = (GameState) inputStream.readObject();
            board = gameState.getBoard();
            currentPlayer = gameState.getCurrentPlayer();
            updateUI();  // Método que actualiza la interfaz de usuario según el estado cargado
            System.out.println("Partida cargada correctamente.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Método para actualizar la interfaz de usuario según el estado actual del juego
    private void updateUI() {
        SwingUtilities.invokeLater(() -> {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    buttons[i][j].setText(String.valueOf(board[i][j]));
                }
            }
        });
    }
}