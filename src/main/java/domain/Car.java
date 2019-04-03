/*
 * Car
 * 
 * version 1.0
 * 
 * 2019. 4. 2
 * 
 * Created by Wongeun Song
 */

package domain;

import java.util.Random;

public class Car {
	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}

	private boolean canMove() {
		Random random = new Random();

		if (random.nextInt(10) >= 4) {
			return true;
		}
		return false;
	}

	public void move() {
		if (this.canMove()) {
			this.position++;
		}
	}

	public void printPosition() {
		String result = this.name + " : ";

		for (int i = 0; i < position; i++) {
			result += "-";
		}
		System.out.println(result);
	}
}
