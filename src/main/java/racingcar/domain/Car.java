package racingcar.domain;

import java.util.Objects;
import java.util.stream.IntStream;

import racingcar.utils.Constant;
import racingcar.utils.Util;

public class Car {
	private final String name;
	private int position = Constant.START_POSITION;

	public Car(String name) {
		this.name = name;
	}

	public static Car of(Name name) {
		return new Car(name.getName());
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

	public void move() {
		if (Util.getRandomNumber() >= Constant.MOVING_STANDARD_NUMBER)
			this.position++;
	}

	public String getTrackWithName() {
		StringBuilder result = new StringBuilder();
		result.append(this.name);
		result.append(" : ");
		IntStream.range(Constant.START_INCLUSIVE, this.position)
			.forEach(i -> result.append("-"));
		return result.toString();
	}

	public int getPosition() {
		return position;
	}

	public boolean isSamePosition(int maxPosition) {
		return this.position == maxPosition;
	}

	@Override
	public String toString() {
		return name;
	}
}
