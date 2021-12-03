package racingcar;

import static racingcar.Utility.*;

public class Car {

	public static final int MOVING_CRITERIA = 4;
	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	public void moveOrStay() {
		int randomNumber = createRandomNumber();
		if (randomNumber >= MOVING_CRITERIA) {
			this.position++;
		}
	}

}
