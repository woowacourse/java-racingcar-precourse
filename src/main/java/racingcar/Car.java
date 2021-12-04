package racingcar;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import racingcar.util.Assertions;

public class Car {
	private static final int NAME_LENGTH = 5;

	private static final int MOVING_FORWARD = 4;
	private static final String POSITION = "-";

	private final String name;
	private int position = 0;

	public Car(String name) {
		Assertions.throwExceptionIsTrue(name.length() > NAME_LENGTH, ErrorInfo.LENGTH);
		this.name = name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Car)) {
			return false;
		}
		Car car = (Car)o;
		return Objects.equals(name, car.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	public void move(int movePoint) {
		if (movePoint >= MOVING_FORWARD) {
			this.position++;
		}
	}

	@Override
	public String toString() {
		return new StringBuilder()
			.append(this.name)
			.append(" : ")
			.append(IntStream.range(0, this.position)
				.mapToObj(i -> POSITION)
				.collect(Collectors.joining())).toString();
	}
}
