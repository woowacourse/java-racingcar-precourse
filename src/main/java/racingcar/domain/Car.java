package racingcar.domain;

import java.util.Objects;
import java.util.stream.IntStream;

import racingcar.utils.Util;

public class Car {
	private final String name;
	private int position = 0; // 생성자에서 따로 받지 않는 인스턴스변수는 선언시 초기화해줘야한다.

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
		if (Util.getRandomNumber() >= 4)
			this.position++;
	}

	public String getTrackWithName() {
		StringBuilder result = new StringBuilder();
		result.append(this.name);
		result.append(" : ");
		IntStream.range(0, this.position)
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
