package ticTacToe;

import java.io.*;

// Clase que representa el estado de una partida para ser serializada
public class GameState implements Serializable {
    private char[][] board;  // Matriz que representa el tablero del juego
    private char currentPlayer;  // Jugador actual (X o O)

    // Constructor que toma el tablero y el jugador actual
    public GameState(char[][] board, char currentPlayer) {
        this.board = board;
        this.currentPlayer = currentPlayer;
    }

    // Método para obtener el tablero
    public char[][] getBoard() {
        return board;
    }

    // Método para obtener el jugador actual
    public char getCurrentPlayer() {
        return currentPlayer;
    }
}
