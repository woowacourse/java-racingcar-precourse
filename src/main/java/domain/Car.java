/*
 * 클래스명 : Car
 * 
 * version : 0.1
 * 
 * 날짜 : 2019.12.08
 * 
 * 작성자 : ParkDooWon
 */
package domain;

import java.util.Random;

public class Car {
	private static final Random random = new Random();
	private static final int MAX_RANDOM_NUM = 10;
	private static final int CAN_MOVE = 4;
	private static final int CANT_MOVE = 3;
	private static final int STAY = 0;
	private static final String IS = " : ";
	private final String name;
	private int position = 0;
	private int randNum;

	public Car(String name) {
		this.name = name;
	}

	public void makeRandomNum() {
		this.randNum = random.nextInt(MAX_RANDOM_NUM);
	}

	public void move() {
		if (randNum >= CAN_MOVE) {
			this.position++;
		} else if (randNum <= CANT_MOVE) {
			this.position += STAY;
		}
	}

	public void printCarPosition(char shape) {
		System.out.println(this.name + IS + printShapes(shape));
	}

	private String printShapes(char shape) {
		String shapes = "";
		for (int i = 0; i < this.position; i++) {
			shapes += shape;
		}
		return shapes;
	}
	
	public int findWinnerPosition(int tempPosition) {
		int biggerPosition = tempPosition;
		if (this.position >= tempPosition) {
			biggerPosition = this.position;
		} else if (this.position < tempPosition) {
			biggerPosition = tempPosition;
		}
		return biggerPosition;
	}
	
	public boolean isWinner(int winnerPosition) {
		if (this.position == winnerPosition) {
			return true;
		}
		return false;
	}
	
	public String getWinnerName() {
		return this.name;
	}

}
