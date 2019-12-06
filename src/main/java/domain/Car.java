package domain;

import java.util.Random;

public class Car {
	private static final int MAX_NUM = 10;
	private static final int CRITERIA_SCORE = 4;
	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	// 추가 기능 구현
	int getPosition() {
		return this.position;
	}

	String getName() {
		return this.name;
	}

	private int getRandomNumber() {
		int randomNumber;
		Random random = new Random();
		randomNumber = random.nextInt(MAX_NUM);
		return randomNumber;
	}

	void move() {
		int randomNumber = getRandomNumber();
		if (randomNumber >= CRITERIA_SCORE) {
			this.position++;
		}
	}

}
