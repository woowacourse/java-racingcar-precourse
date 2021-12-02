package racingcar.domain;

import static constants.RacingCarConstant.*;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
	private final String name;
	private int position;

	public Car(String name) {
		this.name = name;
		this.position = 0;
	}

	public void moveCar() {
		int carMoveNum = Randoms.pickNumberInRange(CAR_MOVE_LOWER_BOUND, CAR_MOVE_UPPER_BOUND);
		if (carMoveNum >= CAR_MOVE_CHECK_NUM) {
			position += CAR_MOVE;
		}
	}

	public String getName() {
		return name;
	}

	public Integer getPosition(){
		return position;
	}
}
