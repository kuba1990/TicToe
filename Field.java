package com.TicToe.app.TicToe;

import java.math.BigDecimal;

public class Field {

	public Field(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Field [value=" + value + ", x=" + x + ", y=" + y + "]";
	}

	private String value;// X,O, null

	private int x;

	private int y;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}

	

