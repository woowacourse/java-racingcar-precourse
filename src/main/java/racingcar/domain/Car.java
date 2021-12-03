package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car implements Comparable<Car> {
	private final String name;
	private int position = 0;
	private static final int CONDITION_FOR_MOVE = 4;
	private static final int MIX_RANDOM_NUMBER = 0;
	private static final int MAX_RANDOM_NUMBER = 9;
	private static final String CAR_POSITION_BY_FORMATTER = "-";
	private static final String CAR_STATUS_DELIMITER = " : ";

	public Car(String name) {
		this.name = name;
	}

	public void attemptMoving() {
		if (Randoms.pickNumberInRange(MIX_RANDOM_NUMBER, MAX_RANDOM_NUMBER) >= CONDITION_FOR_MOVE) {
			position++;
		}
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}

	public boolean isSamePosition(Car car) {
		return this.position == car.getPosition();
	}

	public String getStatusByFormatter() {
		return name + CAR_STATUS_DELIMITER + CAR_POSITION_BY_FORMATTER;
	}

	@Override
	public int compareTo(Car car) {
		return car.getPosition() - getPosition();
	}
}
