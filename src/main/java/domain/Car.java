package domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
	private static final int MINIMUM_RANDOM_NUMBER = 0;
	private static final int MAXIMUM_RANDOM_NUMBER = 9;
	private static final int MOVING_STANDARD_NUMBER = 4;

	private final Name name;
	private Position position = new Position();

	public Car(Name name) {
		this.name = name;
	}

	public Name getName() {
		return this.name;
	}

	public Position getPosition() {
		return this.position;
	}

	public boolean isSamePosition(Position position) {
		return this.position.toInt() == position.toInt();
	}

	public void moveForward() {
		if (willMove()) {
			this.position = this.position.increase();
		}
	}

	private boolean willMove() {
		int randomNumber = Randoms.pickNumberInRange(MINIMUM_RANDOM_NUMBER, MAXIMUM_RANDOM_NUMBER);
		return randomNumber >= MOVING_STANDARD_NUMBER;
	}
}
