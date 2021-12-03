package racingcar.domain;

import static camp.nextstep.edu.missionutils.Randoms.*;
import static racingcar.constant.GameConstants.*;
import static racingcar.constant.GameMessage.*;

public class Car {
	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
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

	public StringBuilder getNameAndPostionMessage() {
		StringBuilder result = new StringBuilder();
		result.append(name);
		result.append(COLON);
		for (int i = 0; i < position; i++) {
			result.append(ONE_STEP);
		}
		result.append("\n");
		return result;
	}

	public boolean isInPosition(int position) {
		return this.position == position;
	}
}
