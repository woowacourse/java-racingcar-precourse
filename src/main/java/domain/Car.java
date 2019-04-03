package domain;

import java.util.Random;

public class Car {
	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	// 추가 기능 구현
	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}

	public void oneRound() {
		makeRandomNumber();
		move();
		printResult();
	}

	public int makeRandomNumber() {
		Random random = new Random();
		return random.nextInt(10);
	}

	public void move() {
		int randomNumber = makeRandomNumber();
		if (randomNumber > 3) {
			position += 1;
		}
	}

	private void printResult() {
		// TODO

	}
}
