package racingcar;

import java.util.Objects;

public class Car {
	private static final int MAX_LENGTH = 5;

	private final String name;
    private int position = 0;

    public Car(String name) {
		if (isNameOverMaxLength(name)) {
			throw new IllegalArgumentException();
		}
        this.name = name;
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
