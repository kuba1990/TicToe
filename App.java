package com.TicToe.app.TicToe;

import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		int minLevel = 0;

		int playerInGame = Game.whoFirstAsNumber();

		String[] playersArray = new String[2];

		Scanner inputName1 = new Scanner(System.in);

		System.out.println("provide user 1 name");

		playersArray[0] = inputName1.nextLine();
		/* String playerFirst = inputName1.nextLine(); */

		System.out.println("provide user 2 name");

		Scanner inputName2 = new Scanner(System.in);
		playersArray[1] = inputName2.nextLine();

		Scanner inputLevel = new Scanner(System.in);

		int level; /* = inputLevel.nextInt(); */

	/*	do {
			System.out.println("please input game level - should be higher than 3");
			while (!inputLevel.hasNextInt()) {
				System.out.println("please input game level - should be higher than 3 again!");
				inputLevel.next(); // this is important!
			}
			level = inputLevel.nextInt();
		} while (level < 3 || level > 99999);
		System.out.println("level is " + level );*/
		

		
		do{
			System.out.println("please input game level - should be higher than 2");
			level = inputLevel.nextInt();
		}while(level<3);
		
		
		String player = Game.whoFirst();

		// sysout who first

		System.out.println("starts " + playersArray[playerInGame] + " with :" + player);

		// TODO SETUP BOARD

		Board board = new Board();

		board.setUpBoard(level);

		// TODO WHILE WHO IS WINNER

		while (board.checkWinner().equals(Constants.PLAY)) {

			board.display();

			Scanner coordinatesScanner = new Scanner(System.in);

			int x;
			int y;

			int fieldOnBoard = level /*- 1*/;

			do {
				System.out.println("Provide coordindate X between " + "1-" + "  " + fieldOnBoard);
				while (!coordinatesScanner.hasNextInt()) {
					System.out.println("Please enter a valid coordinates!");
					coordinatesScanner.next();
				}
				x = coordinatesScanner.nextInt();
			} while (x < 1 || x > fieldOnBoard);

			do {
				System.out.println("Provide coordindate Y between " + "1-" + "  " + fieldOnBoard);
				while (!coordinatesScanner.hasNextInt()) {
					System.out.println("Please enter a valid coordinates!");
					coordinatesScanner.next();
				}
				y = coordinatesScanner.nextInt();
			} while (y < 1 || y > fieldOnBoard);

			Field checkFieldOnBoard = board.getField(x-1, y-1);

			if (checkFieldOnBoard.getValue() == null) {
				Field field = new Field(x-1, y-1);
				field.setValue(player);

				player = Game.changePlayer(player);

				System.out.println("Turn " + player);

				board.setField(field);
				System.out.println();

			}

			System.out.println("field accuppaded " + "Turn " + player + " on free field");

		}

	}

}
