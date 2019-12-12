package com.company;

public class Main {

    public static void main(String[] args) {
	    Board gameBoard = new Board();
	    Prompter prompter = new Prompter();
	    Player playerOne;
	    Player playerTwo;
	    boolean choiceGameLoop = true;
	    while (choiceGameLoop) {
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
			Player whatPlayer = playerOne;
			while (gameLoop) {
				boolean checkInput = false;
				clearScreen();
				gameBoard.printBoard();
				while (!checkInput) {
					int playerMove = whatPlayer.makeMove();
					if (playerMove >= 1 && playerMove <= 9) {
						if (gameBoard.makePlay(playerMove, whatPlayer.getPlayerGameSymbol())) {
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
					break;
				}
				if (gameBoard.isNoMoves()) {
					gameBoard.printBoard();
					prompter.fullBoard();
					break;
				}
				if (whatPlayer == playerOne) {
					whatPlayer = playerTwo;
				} else {
					whatPlayer = playerOne;
				}
			}
			prompter.checkPointStanding(playerOne, playerTwo);
			switch (prompter.afterGameMenu()) {
				case 1:
					gameBoard.initializeBoard();
					break;
				case 2:
					gameBoard.initializeBoard();
					gameLoop = false;
					break;
				case 3:
					gameLoop = false;
					choiceGameLoop = false;
					break;

			}

		}

	}
	private static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}
}
