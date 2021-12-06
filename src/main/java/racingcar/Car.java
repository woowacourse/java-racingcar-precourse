package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
	private static final int MIN = 0;
	private static final int MAX = 9;

	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	public int generateRandomValue() {
		return Randoms.pickNumberInRange(MIN, MAX);
	}
}
