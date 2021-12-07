package racingcar.domain;

import racingcar.utils.Constant;
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

	public void move() {
		int distance = Randoms.pickNumberInRange(Constant.RANDOM_RANGE_MINIMUM, Constant.RANDOM_RANGE_MAXIMUM);
		if (distance >= Constant.RANDOM_RANGE_STANDARD) {
			this.position += distance;
		}
	}

}
