package racingcar.domain;

import racingcar.util.Constant;

public class Car implements Comparable<Car> {
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

	public String getPositionAsString() {
		StringBuilder moveResult = new StringBuilder();
		for (int i = 0; i < position; i++) {
			moveResult.append(Constant.MOVE_MARK);
		}
		return moveResult.toString();
	}

	public void move(int randomNumber) {
		if (randomNumber >= Constant.MOVE_MIN_VALUE) {
			position++;
		}
	}

	@Override
	public int compareTo(Car o) {
		if (position >= o.position) {
			return 1;
		}
		return -1;
	}
}
