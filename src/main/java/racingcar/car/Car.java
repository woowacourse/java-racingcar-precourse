package racingcar.car;

import static camp.nextstep.edu.missionutils.Randoms.*;

public class Car {
	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	private boolean canMove() {
		if (pickNumberInRange(0, 9) >= 4) {
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
