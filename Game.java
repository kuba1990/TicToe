package com.TicToe.app.TicToe;

import java.util.Random;

public class Game {

	public static String whoFirst() {
		Random rand = new Random();

		int n = rand.nextInt(2) + 1;

		if (n == 1) {
			return Constants.X;

		} else {
			return Constants.O;
		}

	}

	public static String changePlayer(String currentPlayer) {

		if (currentPlayer.equals(Constants.X)) {
			return Constants.O;

		} else {
			return Constants.X;
		}

	}

	public static int whoFirstAsNumber() {
		Random rand = new Random();

		int n = rand.nextInt(1);

		return n;

	}

}
