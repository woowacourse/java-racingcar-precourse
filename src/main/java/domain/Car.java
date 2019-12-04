package domain;

import java.util.Random;

public class Car {
	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	public int randomizeNumber() {
		Random generator = new Random();
		int randomNumber = generator.nextInt(10);
		return randomNumber;
	}
}
