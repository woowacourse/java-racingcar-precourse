package racingcar;

import java.util.Objects;

public class Car {
	private static final int MAX_LENGTH = 5;
	private static final int MOVABLE_NUMBER = 4;

	private final String name;
	private int position = 0;

	public Car(String name) {
		if (isNameOverMaxLength(name)) {
			throw new IllegalArgumentException();
		}
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}

	public void controlByNumber(int number) {
		if (getStatusByNumber(number).isMove()) {
			position++;
		}
	}

	private CarStatus getStatusByNumber(int number) {
		if (number < MOVABLE_NUMBER) {
			return CarStatus.STOP;
		}
		return CarStatus.MOVE;
	}

	private boolean isNameOverMaxLength(String name) {
		return name.length() > MAX_LENGTH;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Car car = (Car)o;
		return position == car.position && Objects.equals(name, car.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, position);
	}

}
