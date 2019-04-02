package domain;

import java.util.Random;

public class Car {
	private final String name;
	private int position = 0;
	private Random random = new Random();

	public Car(String name) {
		this.name = name;
	}

	public void race() {
		if (random.nextInt(10) >= 4) {
			position++;
		}
	}
}
