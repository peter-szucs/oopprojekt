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

    public void promptForPlayerInput(Player whatPlayer) {
        System.out.println("\n\n" + whatPlayer.getName() + "(" +
                whatPlayer.getPlayerType() + ")" +
                ", your move! (1-9): ");
        boolean checkInput = false;
        int playerMove = 0;
        while (!checkInput) {
            try {
                playerMove = playerInput.nextInt();
                if (playerMove >= 1 && playerMove <= 9) {
                    if(board.makePlay(playerMove, whatPlayer.getPlayerType())) {
                        checkInput = true;
                    } else {
                        System.out.println("That spot is taken. Try a free one!");
                    }
                } else {
                    wrongInput(1, 9);
                }
            } catch (Exception e) {
                wrongInput(1, 9);
            }
            playerInput.nextLine();
        }
    }

    private void wrongInput(int min, int max) {
        System.out.println("Only numbers between " + min + "-" + max + " please!");
    }

    public void gameOver() {
        System.out.println("");
    }
}
