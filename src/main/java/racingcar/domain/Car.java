package racingcar.domain;

import racingcar.handler.PrintHandler;

public class Car {
	private static final int MOVE_VALUE = 4;

	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	// 추가 기능 구현
	public void playOnce(int randomNumber) {
		move(randomNumber);
		print();
	}

	private void move(int randomNumber) {
		if (checkMove(randomNumber)) {
			position++;
		}
	}

	private void print() {
		PrintHandler.printCar(this);
	}

	private boolean checkMove(int number) {
		return number >= MOVE_VALUE;
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}
}
