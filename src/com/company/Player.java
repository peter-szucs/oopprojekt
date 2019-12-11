package com.company;

public class Player {
    private String name;
    private String playerType;
    private int numberOfWins;

    public int getNumberOfWins() {
        return numberOfWins;
    }

    public void setNumberOfWins(int numberOfWins) {
        this.numberOfWins = numberOfWins;
    }

    public String getPlayerType() {
        return playerType;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Player(String playerType) {
        this.playerType = playerType;
    }
}
