package com.TicToe.app.TicToe;


import java.util.ArrayList;
import java.util.List;

public class Board {

	private int size;

	private List<Field> fields = new ArrayList<Field>();

	public void setField(Field field) {

		Field fieldOnBoard = getField(field.getX(), field.getY());
		fieldOnBoard.setValue(field.getValue());

	}

	public void display() {

		System.out.println("1 "+"X ----->");

		for (int y = 0; y < size; y++) {

			for (int x = 0; x < size; x++) {
				System.out.print("|");

				System.out.print("_");

				String fieldValue = getField(x, y).getValue();
				if (fieldValue == null) {
					System.out.print(" ");
				} else {
					System.out.print(getField(x, y).getValue());
				}

			}
			System.out.println("|");

		}
		for (int x = 0; x < size; x++) {
			System.out.print("  " + " ");
		}
		System.out.println(size +"Y" + "↓");
	}

	public void addField(Field field) {

		fields.add(field);

	}

	public Field getField(int x, int y) {

		for (Field element : fields) {
			if (element.getX() == x && element.getY() == y) {
				return element;

			}
		}

		throw new NoFieldException();



	}

	public void setUpBoard(int size) {

		this.size = size;

		for (int row = 0; row < size; ++row) {
			for (int col = 0; col < size; ++col) {
				fields.add(new Field(row, col));

			}

		}

	}

	public void showFields() {

		System.out.println(fields);
	}

	public String checkWinner() {

		String resultHorizontal = checkHorizontal();

		String resultDiagonal = checkDiagonal();

		String resultDiagonal2 = checkDiagonal2();

		String resultVertical = checkVertical();

		if (resultDiagonal.equals(Constants.X) || resultDiagonal.equals(Constants.O)) {
			return resultDiagonal;

		} else if (resultDiagonal2.equals(Constants.X) || resultDiagonal2.equals(Constants.O)) {
			return resultDiagonal2;

		} else if (resultHorizontal.equals(Constants.X) || resultHorizontal.equals(Constants.O)) {
			return resultHorizontal;

		} else {
			return resultVertical;

		}

	}

	private String checkDiagonal() {

		List<String> diagonalValues = new ArrayList<String>();

		int counterX = 0;
		int counterO = 0;

		for (int x = 0; x < size; x++) {

			String value = getField(x, x).getValue();// create variable

			if (value != null) {
				diagonalValues.add(value);
				if (Constants.X.equals(value)) {
					counterX++;
				} else if (Constants.O.equals(value)) {
					counterO++;
				}
			}

		}

		if (size > diagonalValues.size()) {

			return Constants.PLAY;

		} else if (size == counterX) {

			return Constants.X;

		} else if (size == counterO) {

			return Constants.O;
		} else if (size == diagonalValues.size() && counterX < size) {
			return Constants.DRAW;
		}
		return null;
	}

	private String checkDiagonal2() {

		List<String> diagonalValues = new ArrayList<String>();

		int counterX = 0;
		int counterO = 0;

		for (int x = size - 1, y = 0; y < size; x--, y++) {

			String value = getField(x, y).getValue();// tworze zmienna

			if (value != null) {
				diagonalValues.add(value);
				if (Constants.X.equals(value)) {
					counterX++;
				} else if (Constants.O.equals(value)) {
					counterO++;
				}
			}

		}
		if (size > diagonalValues.size()) {

			return Constants.PLAY;

		} else if (size == counterX) {

			return Constants.X;

		} else if (size == counterO) {

			return Constants.O;
		} else if (size == diagonalValues.size() && counterX < size) {
			return Constants.DRAW;
		}

		return null;
	}

	private String checkVertical() {

		int counterX = 0;
		int counterO = 0;

		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {

				String value = getField(x, y).getValue();
				/* System.out.println(value + "Y" + y + " X" + x); */

				if (value != null) {
					if (value.equals(Constants.X)) {
						counterX++;
					} else if (value.equals(Constants.O)) {
						counterO++;
					}

				}
			}
			if (counterX == size) {
				return Constants.X;

			} else if (counterO == size) {
				return Constants.O;

			} else {
				return Constants.PLAY;

			}
		}
		return null;

	}

	private String checkHorizontal() {

		int counterX = 0;
		int counterO = 0;

		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {

				String value = getField(y, x).getValue();
				/* System.out.println(value + "Y" + y + " X" + x); */

				if (value != null) {

					if (value.equals(Constants.X)) {
						counterX++;
					} else if (value.equals(Constants.O)) {
						counterO++;
					}

				}
			}
			if (counterX == size) {
				return Constants.X;

			} else if (counterO == size) {
				return Constants.O;

			} else {
				return Constants.PLAY;

			}
		}
		return null;

	}
}
