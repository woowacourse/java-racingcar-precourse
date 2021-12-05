package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constant.RacingCarConst;

public class Car {
	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	public void go() {
		if (isGoing()) {
			position += 1;
		}
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}

	private boolean isGoing() {
		int randomNum = Randoms.pickNumberInRange(RacingCarConst.RANDOM_MIN, RacingCarConst.RANDOM_MAX);
		return randomNum >= RacingCarConst.TOGO_MIN;
	}
}
