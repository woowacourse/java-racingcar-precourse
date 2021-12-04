package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}

	public void calculateMove() {
		int randomNumber = Randoms.pickNumberInRange(Constant.MINIMUM_RANDOM_NUMBER, Constant.MAXIMUM_RANDOM_NUMBER);
		if (randomNumber >= Constant.MOVE_NUMBER) {
			position += 1;
		}
	}
}
