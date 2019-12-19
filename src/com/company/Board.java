package com.company;

public class Board {
    private String[][] board;
    private static final int ROWS = 3;
    private static final int COLS = 3;
    private static final String EMPTY = "   ";

    public String[][] getBoard() {
        return board;
    }

    public static int getROWS() {
        return ROWS;
    }

    public static int getCOLS() {
        return COLS;
    }

    public static String getEMPTY() {
        return EMPTY;
    }

    public Board() {
        board = new String[ROWS][COLS];
        initializeBoard();
    }

    public void initializeBoard() {
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

    public boolean isSpotEmpty(int spot) {
        if (this.board[calculateRow(spot)][calculateCol(calculateRow(spot), spot)].matches(EMPTY)) {
            return true;
        }
        return false;
    }
    public void makePlay(int spot, String player) {
        board[calculateRow(spot)][calculateCol(calculateRow(spot), spot)] = " " + player + " ";
    }
    private int calculateRow(int spot) {
        return (int) Math.floor((spot - 1) / 3);
    }
    private int calculateCol(int row, int spot) {
        return (spot - (row * 3)) - 1;
    }

    public boolean isGameOver() {
        // check rows
        for (int i = 0; i < ROWS; i++) {
            if (!board[i][0].matches(EMPTY) &&
                    board[i][0].equals(board[i][1]) &&
                    board[i][1].equals(board[i][2])) {
                return true;
            }
        }
        // check columns
        for (int j = 0; j < COLS; j++) {
            if (!board[0][j].matches(EMPTY) &&
                    board[0][j].equals(board[1][j]) &&
                    board[1][j].equals(board[2][j])) {
                return true;
            }
        }
        // check diagonals
        if (!board[0][0].matches(EMPTY) &&
                board[0][0].equals(board[1][1]) &&
                board[1][1].equals(board[2][2])) {
            return true;
        }
        if (!board[0][2].matches(EMPTY) &&
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
                if (board[i][j].matches(EMPTY)) {
                    return false;
                }
            }
        }
        return true;
    }
}
