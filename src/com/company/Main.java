package com.company;

public class Main {

    public static void main(String[] args) {
	    Board gameBoard = new Board();
	    Prompter prompter = new Prompter();
	    Player playerOne;
	    Player playerTwo;
		Player whatPlayer;
	    boolean choiceGameLoop = true;
	    while (choiceGameLoop) {
			boolean outerGameLoop = true;
			boolean gameLoop = true;
			if (prompter.gameMenu()) {
				playerOne = new Human("X");
				playerTwo = new Human("O");
				playerOne.setName(prompter.initializePlayer("X"));
				playerTwo.setName(prompter.initializePlayer("O"));
			} else {
				playerOne = new Human("X");
				playerTwo = new AI("O", gameBoard);
				playerOne.setName(prompter.initializePlayer("X"));
			}
			while (outerGameLoop) {
				whatPlayer = playerOne;
				while (gameLoop) {
					boolean checkInput = false;
					clearScreen();
					gameBoard.printBoard();
					while (!checkInput) {
						int playerMove = whatPlayer.makeMove();
						if (playerMove >= 1 && playerMove <= 9) {
							if (gameBoard.isSpotEmpty(playerMove)) {
								gameBoard.makePlay(playerMove, whatPlayer.getPlayerGameSymbol());
								checkInput = true;
							} else {
								System.out.println("That spot is taken. Try a free one!");
							}
						} else {
							prompter.wrongInput(1, 9);
						}
					}
					//whatPlayer.makeMove();
					//prompter.promptForPlayerInput(whatPlayer);
					if (gameBoard.isGameOver()) {
						gameBoard.printBoard();
						prompter.gameOver(whatPlayer);
						gameLoop = false;
					} else if (gameBoard.isNoMoves()) {
						gameBoard.printBoard();
						prompter.fullBoard();
						gameLoop = false;
					}
					if (whatPlayer == playerOne) {
						whatPlayer = playerTwo;
					} else {
						whatPlayer = playerOne;
					}
				}
				prompter.printPointStanding(playerOne, playerTwo);
				switch (prompter.afterGameMenu()) {
					case 1:
						gameBoard.initializeBoard();
						gameLoop = true;
						break;
					case 2:
						gameBoard.initializeBoard();
						outerGameLoop = false;
						break;
					case 3:
						outerGameLoop = false;
						choiceGameLoop = false;
						prompter.goodBye();
						break;

				}
			}

		}

	}
	private static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}
}
