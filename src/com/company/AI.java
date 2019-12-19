package com.company;

import java.util.Random;

public class AI extends Player {
    private int difficulty;
    Board gameBoard;
    int[] preferredMoves;
    int nextMove;
    String computerMarker = " O ";
    String humanMarker = " X ";

    public AI(String playerGameSymbol, Board gameBoard) {
        super(playerGameSymbol);
        this.gameBoard = gameBoard;
        setName("SkyNetAI");
        initializeAI();
    }

    public static int[] randomizePreferredArray(int[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            int randomPosition = random.nextInt(array.length);
            int temp = array[i];
            array[i] = array[randomPosition];
            array[randomPosition] = temp;
        }
        return array;
    }

    public int makeMove() {
        System.out.print("\n" + getName() + "'s turn!\n\n");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return decideMove();
    }

    private int decideMove() {
        if (nextMoveCritical(computerMarker)) {
            return nextMove;
        } else if (nextMoveCritical(humanMarker)) {
            return nextMove;
        } else if (nextMovePreferred()) {
            return nextMove;
        } else {
            for (int i = 1; i <= 9; i++) {
                if (gameBoard.isSpotEmpty(i)) {
                    nextMove = i;
                }
            }
        }
        return nextMove;
    }

    private void initializeAI() {
        int[] moves = new int[]{1, 3, 7, 9};
        preferredMoves = randomizePreferredArray(moves);
    }

    private boolean nextMovePreferred() {
        if (gameBoard.isSpotEmpty(5)) {
            nextMove = 5;
            return true;
        } else {
            for (int i = 0; i < preferredMoves.length; i++) {
                if (gameBoard.isSpotEmpty(preferredMoves[i])) {
                    nextMove = preferredMoves[i];
                    return true;
                }
            }
        }
        return false;
    }

    private boolean nextMoveCritical(String player) {
        // check rows
        for (int i = 0; i < gameBoard.getROWS(); i++) {
            if (gameBoard.getBoard()[i][0].matches(player) &&
                    gameBoard.getBoard()[i][0].equals(gameBoard.getBoard()[i][1]) &&
                    gameBoard.getBoard()[i][2].matches(gameBoard.getEMPTY())) {
                nextMove = (i * 3) + 3;
                return true;
            } else if (gameBoard.getBoard()[i][1].matches(player) &&
                    gameBoard.getBoard()[i][1].equals(gameBoard.getBoard()[i][2]) &&
                    gameBoard.getBoard()[i][0].matches(gameBoard.getEMPTY())) {
                nextMove = (i * 3) + 1;
                return true;
            } else if (gameBoard.getBoard()[i][2].matches(player) &&
                    gameBoard.getBoard()[i][2].equals(gameBoard.getBoard()[i][0]) &&
                    gameBoard.getBoard()[i][1].matches(gameBoard.getEMPTY())) {
                nextMove = (i * 3) + 2;
                return true;
            }
        }
        // check columns
        for (int j = 0; j < gameBoard.getCOLS(); j++) {
            if (gameBoard.getBoard()[0][j].matches(player) &&
                    gameBoard.getBoard()[0][j].equals(gameBoard.getBoard()[1][j]) &&
                    gameBoard.getBoard()[2][j].matches(gameBoard.getEMPTY())) {
                nextMove = (2 * 3) + (j + 1);
                return true;
            } else if (gameBoard.getBoard()[1][j].matches(player) &&
                    gameBoard.getBoard()[1][j].equals(gameBoard.getBoard()[2][j]) &&
                    gameBoard.getBoard()[0][j].matches(gameBoard.getEMPTY())) {
                nextMove = j + 1;
                return true;
            } else if (gameBoard.getBoard()[2][j].matches(player) &&
                    gameBoard.getBoard()[2][j].equals(gameBoard.getBoard()[0][j]) &&
                    gameBoard.getBoard()[1][j].matches(gameBoard.getEMPTY())) {
                nextMove = 3 + (j + 1);
                return true;
            }
        }
        // check diagonals
        if (gameBoard.getBoard()[0][0].matches(player) &&
                gameBoard.getBoard()[0][0].equals(gameBoard.getBoard()[1][1]) &&
                gameBoard.getBoard()[2][2].matches(gameBoard.getEMPTY())) {
            nextMove = 9;
            return true;
        } else if (gameBoard.getBoard()[1][1].matches(player) &&
                gameBoard.getBoard()[1][1].equals(gameBoard.getBoard()[2][2]) &&
                gameBoard.getBoard()[0][0].matches(gameBoard.getEMPTY())) {
            nextMove = 1;
            return true;
        } else if (gameBoard.getBoard()[0][0].matches(player) &&
                gameBoard.getBoard()[0][0].equals(gameBoard.getBoard()[2][2]) &&
                gameBoard.getBoard()[1][1].matches(gameBoard.getEMPTY())) {
            nextMove = 5;
            return true;
        }
        if (gameBoard.getBoard()[0][2].matches(player) &&
                gameBoard.getBoard()[0][2].equals(gameBoard.getBoard()[1][1]) &&
                gameBoard.getBoard()[2][0].matches(gameBoard.getEMPTY())) {
            nextMove = 7;
            return true;
        } else if (gameBoard.getBoard()[1][1].matches(player) &&
                gameBoard.getBoard()[1][1].equals(gameBoard.getBoard()[2][0]) &&
                gameBoard.getBoard()[0][2].matches(gameBoard.getEMPTY())) {
            nextMove = 3;
            return true;
        } else if (gameBoard.getBoard()[0][2].matches(player) &&
                gameBoard.getBoard()[0][2].equals(gameBoard.getBoard()[2][0]) &&
                gameBoard.getBoard()[1][1].matches(gameBoard.getEMPTY())) {
            nextMove = 5;
            return true;
        }
        return false;
    }
}
