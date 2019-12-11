package com.company;

public class Main {

    public static void main(String[] args) {
	    Board gameBoard = new Board();
	    Prompter prompter = new Prompter(gameBoard);
	    Player playerOne = new Player("X");
	    Player playerTwo = new Player("O");
		Player whatPlayer = playerOne;
		playerOne.setName(prompter.initializePlayer("X"));
		playerTwo.setName(prompter.initializePlayer("Y"));
		
		while (!gameBoard.isGameOver()) {
			clearScreen();
	        gameBoard.printBoard();
	        prompter.promptForPlayerInput(whatPlayer);
	        if (whatPlayer == playerOne) {
	        	whatPlayer = playerTwo;
			} else {
	        	whatPlayer = playerOne;
			}
        }

    }
	public static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}
}
