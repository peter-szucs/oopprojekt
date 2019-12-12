package com.company;

public class AI extends Player {
    private int difficulty;
    private Board gameBoard = new Board();

    public AI(String playerGameSymbol, Board gameBoard) {
        super(playerGameSymbol);
        this.gameBoard = gameBoard;
        setName("AI");
    }

}
