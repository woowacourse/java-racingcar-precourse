package racingcar;

import static racingcar.util.Constants.*;

import camp.nextstep.edu.missionutils.Randoms;

public class Car implements Comparable<Car> {
	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	public void drive() {
		tryDrive();
		printPosition();
	}

	private void tryDrive() {
		int randomNumber = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
		if (randomNumber >= 4) {
			position++;
		}
	}

	private void printPosition() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(name).append(MESSAGE_SEMICOLON_WITH_SPACE);
		for (int i = 0; i < position; i++) {
			stringBuilder.append(MESSAGE_POSITION);
		}
		System.out.println(stringBuilder);
	}

	@Override
	public int compareTo(Car otherCar) {
		return otherCar.position - this.position;
	}

	String getName() {
		return this.name;
	}
}
