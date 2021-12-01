package racingcar.domain;

import static camp.nextstep.edu.missionutils.Randoms.*;
import static racingcar.constant.GameConstants.*;

public class Car {
	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	public StringBuilder getNameAndPostionMessage() {
		StringBuilder result = new StringBuilder();
		result.append(name);
		result.append(" : ");
		for (int i = 0; i < position; i++) {
			result.append(ONE_STEP);
		}
		result.append("\n");
		return result;
	}

	public void movePosition() {
		int randomNumber = pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
		if (isRandomNumberSatisfiedCondition(randomNumber)) {
			this.position += 1;
		}
	}

	private boolean isRandomNumberSatisfiedCondition(int randomNumber) {
		return randomNumber >= MIN_VALUE_OF_SATISFIED_CONDITION;
	}
}
