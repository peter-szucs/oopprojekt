package com.company;

public class Human extends Player {
    public Human(String playerGameSymbol) {
        super(playerGameSymbol);
    }

    public int makeMove() {
        Prompter prompter = new Prompter();
        System.out.print("\n" + getName() + "! ");
        return prompter.promptForPlayerInput();
    }
}
