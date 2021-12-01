package domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

	private final Name name;
	private Position position = new Position();

	public Car(Name name) {
		this.name = name;
	}

	public void moveForward() {
		if (willMove()) {
			this.position = this.position.increase();
		}
	}

	private boolean willMove() {
		int randomNumber = Randoms.pickNumberInRange(0, 9);
		return randomNumber >= 4;
	}
}
