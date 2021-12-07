package racingcar.car;

import static camp.nextstep.edu.missionutils.Randoms.*;
import static racingcar.constant.Constant.*;

public class Car {
	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	private boolean canMove() {
		if (pickNumberInRange(MIN_MOVE, MAX_MOVE) >= MOVE) {
			return true;
		}
		return false;
	}

	public void move() {
		if (canMove()) {
			position += 1;
		}
	}

	public int getPosition() {
		return position;
	}

	public String getName() {
		return name;
	}

}
