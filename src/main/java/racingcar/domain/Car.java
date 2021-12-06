package racingcar.domain;

import static camp.nextstep.edu.missionutils.Randoms.*;
import static racingcar.constant.GameConstants.*;
import static racingcar.constant.GameMessage.*;

public class Car implements Comparable<Car> {
	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
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

	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append(name);
		result.append(COLON);
		appendStep(result);
		return result.toString();
	}

	public StringBuilder appendStep(StringBuilder result) {
		for (int i = 0; i < position; i++) {
			result.append(ONE_STEP);
		}
		result.append("\n");
		return result;
	}

	@Override
	public int compareTo(Car other) {
		return this.position - other.position;
	}

	public boolean isSamePosition(Car other) {
		return this.position == other.position;
	}
}
