package com.company;

public class Human extends Player {
    Prompter prompter = new Prompter();
    public Human(String playerGameSymbol) {
        super(playerGameSymbol);
        //private Prompter prompter = new Prompter();
    }

    public int makeMove() {
        //Prompter prompter = new Prompter();
        System.out.print("\n" + getName() + "! ");
        return prompter.promptForPlayerInput();
    }
}
