package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car implements Comparable<Car> {
	private static final int RANDOM_NUMBER_MAX = 9;
	private static final int RANDOM_NUMBER_MIN = 0;
	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	public void move() {
		int randomNumber = Randoms.pickNumberInRange(RANDOM_NUMBER_MIN, RANDOM_NUMBER_MAX);
		if (randomNumber >= 4) {
			position++;
		}
	}

	public void printTrace() {
		System.out.print(name + " : ");
		for (int i = 0; i < position; i++) {
			System.out.print("-");
		}
		System.out.println();
	}

	public void printName() {
		System.out.print(name);
	}

	@Override
	public int compareTo(Car car) {
		if (this.position > car.position) {
			return 1;
		}
		if (this.position == car.position) {
			return 0;
		}
		return -1;
	}
}
