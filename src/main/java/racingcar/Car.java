package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
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
}
