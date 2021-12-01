package racingcar.domain;

import static racingcar.constant.GameConstants.Car.*;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

	public int getPosition() {
		return position;
	}

	public void moveByNumber(int randomNumber) {
		if (randomNumber >= moveCriterionInclusive.getValue())
			this.position += 1;
	}
}
