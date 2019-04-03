package domain;

import java.util.Random;

public class Car {
	private final String name;
	private int position = 0;
	static final int CRITERION = 3;

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
		if (randomNumber > CRITERION) {
			position += 1;
		}
	}

	public void printResult() {
		System.out.print(name + ":");
		for (int i = 0; i < position; i++) {
			System.out.print("-");
		}
		System.out.println();
	}
}
