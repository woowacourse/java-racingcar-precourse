package racingcar.model;

import static camp.nextstep.edu.missionutils.Randoms.*;

public class Car {

	private static final int RANDOM_NUMBER_LOWER_BOUND = 1;
	private static final int RANDOM_NUMBER_UPPER_BOUND = 9;
	private static final int CAR_MOVE_DECISION_NUMBER = 4;

	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	public void decideMoveOrStop() {
		if (makeRandomNumber() >= CAR_MOVE_DECISION_NUMBER) {
			moveCar();
		}
	}

	private int makeRandomNumber() {
		return pickNumberInRange(RANDOM_NUMBER_LOWER_BOUND, RANDOM_NUMBER_UPPER_BOUND);
	}

	private void moveCar() {
		position++;
	}
}
