package com.company;

import java.util.SortedSet;

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
        String dividers = "";
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

    public void makePlay(int spot, String player) {
        if (this.board)
    }
}
