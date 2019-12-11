package com.company;
import java.util.Scanner;

public class Prompter {
    private Board board;
    private Scanner playerInput = new Scanner(System.in);

    public Prompter(Board board) {
        this.board = board;
    }

    public String initializePlayer(String player) {
        System.out.println("Player " + player + ", type your name: ");
        return playerInput.nextLine();
    }

    public boolean promptForPlayerInput(Player whatPlayer) {
        System.out.println("\n\n" + whatPlayer.getName() + "(" +
                whatPlayer.getPlayerType() + ")" +
                ", your move! (1-9): ");

        return false;
    }
}
