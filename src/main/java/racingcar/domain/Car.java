package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
	private static final int PROCEED_NUM_MIN = 4;
	private static final int RANDOM_NUM_MIN = 0;
	private static final int RANDOM_NUM_MAX = 9;

	private final String carName;
	private int position = 0;

	public Car(String carName) {
		this.carName = carName;
	}

	public void proceedOrPause() {
		if (Randoms.pickNumberInRange(RANDOM_NUM_MIN, RANDOM_NUM_MAX) >= PROCEED_NUM_MIN) {
			this.position++;
		}
	}

	public String getCarName() {
		return this.carName;
	}

	public int getPosition() {
		return this.position;
	}
}