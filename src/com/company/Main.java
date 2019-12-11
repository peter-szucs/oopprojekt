package com.company;
import java.util.*;

public class Main {

    public static void main(String[] args) {
	    Scanner playerInput = new Scanner(System.in);
	    Board gameBoard = new Board();
	    Player playerOne = new Player("X");
	    Player playerTwo = new Player("O");
		System.out.println("Player X, type your name: ");
		playerOne.setName(playerInput.nextLine());
		System.out.println("Player O, type your name: ");
		playerTwo.setName(playerInput.nextLine());
	    //do {
	        gameBoard.printBoard();
	        System.out.println(playerOne.getName() + "(" + playerOne.getPlayerType() + ")" + ", your move! (1-9)");
        //} while (true);
    }
}
