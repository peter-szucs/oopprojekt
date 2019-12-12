package com.company;

public abstract class Player {
    private String name;
    private String playerGameSymbol;
    private int numberOfWins;

    public int getNumberOfWins() {
        return numberOfWins;
    }

    public void setNumberOfWins(int numberOfWins) {
        this.numberOfWins += numberOfWins;
    }

    public String getPlayerGameSymbol() {
        return playerGameSymbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Player(String playerGameSymbol) {
        this.playerGameSymbol = playerGameSymbol;
    }

    public int makeMove() {
        return 0;
    }
}
