package com.company;

public class Board {
    private String[][] board;
    private static final int ROWS = 3;
    private static final int COLS = 3;
    private String empty = "   ";

    public Board() {
        board = new String[ROWS][COLS];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                board[i][j] = "   ";
            }
        }
    }

    public void printBoard() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (j != COLS-1) {
                    System.out.print(board[i][j] + "|");
                } else
                    System.out.print(board[i][j]);
            }
            if (i != COLS-1)
                System.out.print("\n---+---+---\n");

        }
    }

    public boolean makePlay(int spot, String player) {
        int row = (int) Math.floor((spot - 1) / 3);
        int col = (spot - (row * 3)) - 1;
        if (this.board[row][col].equals(empty)) {
            board[row][col] = " " + player + " ";
        } else {
            return false;
        }
        return true;
    }

    public boolean isGameOver() {
        // check rows
        for (int i = 0; i < ROWS; i++) {
            if (!board[i][0].matches(empty) &&
                    board[i][0].equals(board[i][1]) &&
                    board[i][1].equals(board[i][2])) {
                return true;
            }
        }
        // check columns
        for (int j = 0; j < COLS; j++) {
            if (!board[0][j].matches(empty) &&
                    board[0][j].equals(board[1][j]) &&
                    board[1][j].equals(board[2][j])) {
                return true;
            }
        }
        // check diagonals
        if (!board[0][0].matches(empty) &&
                board[0][0].equals(board[1][1]) &&
                board[1][1].equals(board[2][2])) {
            return true;
        }
        if (!board[0][2].matches(empty) &&
                board[0][2].equals(board[1][1]) &&
                board[1][1].equals(board[2][0])) {
            return true;
        }

        // no winner
        return false;
    }

    public boolean isNoMoves() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (board[i][j].matches(empty)) {
                    return false;
                }
            }
        }
        return true;
    }
}
