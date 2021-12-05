package racingcar.domain;

import static racingcar.view.OutputView.*;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.enums.DomainConditions;

public class Car {
	private static final int RANDOM_START_NUMBER = DomainConditions.RANDOM_START_NUMBER.get();
	private static final int RANDOM_END_NUMBER = DomainConditions.RANDOM_END_NUMBER.get();
	private static final int MOVING_POINT_NUMBER = DomainConditions.MOVING_POINT_NUMBER.get();

	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void moveForward() {
		int randomValue = Randoms.pickNumberInRange(RANDOM_START_NUMBER, RANDOM_END_NUMBER);
		if (randomValue >= MOVING_POINT_NUMBER) {
			position++;
		}
	}

	public int compareTo(Car car) {
		return position - car.position;
	}

	public boolean isSamePosition(Car car) {
		return position == car.position;
	}

	public void printState() {
		printCarState(name, position);
	}
}
