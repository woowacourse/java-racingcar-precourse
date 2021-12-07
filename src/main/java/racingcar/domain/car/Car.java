package racingcar.domain.car;

import racingcar.movement.MovementWay;
import racingcar.movement.RandomMovement;

public class Car {
	public static final int MINIMUM_POSITION = 0;
	private static final int NAME_MAXIMUM_LENGTH = 5;

	private final String name;
	private final MovementWay movementWay;
	private int position = 0;

	public Car(String name) {
		validateNameEmpty(name);
		validateNameLength(name);

		this.name = name;
		this.movementWay = new RandomMovement();
	}

	public void move() {
		int distance = movementWay.getMovableDistance();
		this.position += distance;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(name);

		sb.append(" : ");
		for (int i = 0; i < position; i++) {
			sb.append("-");
		}
		return sb.toString();
	}

	private void validateNameLength(String name) {
		if (name.length() > NAME_MAXIMUM_LENGTH) {
			throw new IllegalArgumentException("[ERROR] 자동차의 이름이 5자를 초과했습니다.");
		}
	}

	private void validateNameEmpty(String name) {
		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException("[ERROR] 자동차의 이름이 비어있습니다.");
		}
	}

	public int getPosition() {
		return position;
	}

	public String getName() {
		return name;
	}
}
