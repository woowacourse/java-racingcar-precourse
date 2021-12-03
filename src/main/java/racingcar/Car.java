package racingcar;

import java.util.Objects;

public class Car {
	private static final int CAN_MOVE_POWER_MIN = 4;

	private final String name;
	private int position = 0;

	public Car(String name) {
		CarNameValidator.validate(name);
		this.name = name;
	}

	protected Car(String name, int position) {
		this(name);
		this.position = position;
	}

	public void moveOrStop(int carPower) {
		if (canMove(carPower)) {
			move();
		}
	}

	private void move() {
		position++;
	}

	private boolean canMove(int carPower) {
		return carPower >= CAN_MOVE_POWER_MIN;
	}

	public boolean isSamePosition(int position) {
		return this.position == position;
	}

	//view에서 사용하기 위한 getter들
	public int getPosition() {
		return position;
	}

	public String getName() {
		return name;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || !o.getClass().equals(Car.class)) {
			return false;
		}
		Car other = (Car)o;
		return name.equals(other.name) && position == other.position;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, position);
	}
}
