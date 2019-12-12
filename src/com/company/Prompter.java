package com.company;
import java.util.Scanner;

public class Prompter {
    private Scanner playerInput = new Scanner(System.in);

    public Prompter() {
    }

    public String initializePlayer(String player) {
        System.out.println("Player " + player + ", type your name: ");
        return playerInput.nextLine();
    }

    public boolean gameMenu() {
        while (true) {
            System.out.println("\nWhat type of game do you want to play?" +
                    "\n1. Human vs Human" +
                    "\n2. Human vs AI");
            int input;
            try {
                input = playerInput.nextInt();
                if (input == 1) {
                    playerInput.nextLine();
                    return true;
                } else if (input == 2) {
                    playerInput.nextLine();
                    return false;
                } else {
                    playerInput.nextLine();
                    wrongInput(1, 2);
                }
            } catch (Exception e) {
                playerInput.nextLine();fullBoard();
                wrongInput(1, 2);
            }
        }
    }

    public int promptForPlayerInput() {
        System.out.println("Your move! (1-9): ");
        boolean checkInput = false;
        int playerMove = 0;
        while (true) {
            try {
                playerMove = playerInput.nextInt();
                if (playerMove >= 1 && playerMove <= 9) {
                    playerInput.nextLine();
                    return playerMove;
                    } else {
                    wrongInput(1, 9);
                }
            } catch (Exception e) {
                wrongInput(1, 9);
            }
            playerInput.nextLine();
        }
    }

    public void wrongInput(int min, int max) {
        System.out.println("Only numbers between " + min + "-" + max + " please!");
    }

    public void checkPointStanding(Player p1, Player p2) {
        System.out.println(p1.getName() + " has " + p1.getNumberOfWins() + " wins.\n" +
                p2.getName() + " has " + p2.getNumberOfWins() + " wins.");
    }

    public void gameOver(Player player) {
        System.out.println("\n\nCongratulations " + player.getName() + ". You won!");
        player.setNumberOfWins(1);

    }

    public void fullBoard() {
        System.out.println("\n\nNo more moves left. No winner.");
    }

    public int afterGameMenu() {
        while (true) {
            System.out.println("\nDo you want to play again?" +
                    "\n1. Yes, with same players." +
                    "\n2. Yes, with different players." +
                    "\n3. No, I'm done!");
            int input;
            try {
                input = playerInput.nextInt();
                if (input >= 1 && input <= 3) {
                    playerInput.nextLine();
                    return input;
                } else {
                    playerInput.nextLine();
                    wrongInput(1, 3);
                }
            } catch (Exception e){
                playerInput.nextLine();
                wrongInput(1, 3);
            }
        }
    }
}
