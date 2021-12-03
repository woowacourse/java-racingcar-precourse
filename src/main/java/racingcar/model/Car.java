package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

	private final String name;
	private int position = 0;

	private static final int MINIMUM_RANDOM_RANGE = 0;
	private static final int MAXIMUM_RANDOM_RANGE = 9;

	public Car(String name) {
		this.name = name;
	}

	// 추가 기능 구현
	public int makeRandomNumber() {
		int randomNumber = Randoms.pickNumberInRange(MINIMUM_RANDOM_RANGE, MAXIMUM_RANDOM_RANGE);
		System.out.println(randomNumber);
		return randomNumber;
	}
}
