package com.company;

public class Player {
    private String name;
    private String playerType;

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
