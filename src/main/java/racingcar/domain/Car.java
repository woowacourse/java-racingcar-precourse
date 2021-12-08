package racingcar.domain;

import java.util.Objects;

public class Car {
	private final CarName name;
	private final Position position;

	public Car(final CarName name, final int position) {
		this.name = name;
		this.position = new Position(position);
	}

	public Car(final CarName name) {
		this(name, 0);
	}

	public Car(final String name) {
		this(new CarName(name));
	}

	public String getName() {
		return name.getCarName();
	}

	public int getPosition() {
		return position.getValue();
	}

	public void move(RandomNumberGenerator generator) {
		position.isMove(generator);
	}

	public boolean isWinner(int max) {
		return position.isMax(max);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Car car = (Car)o;
		return Objects.equals(getName(), car.getName()) && Objects.equals(getPosition(),
			car.getPosition());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getName(), getPosition());
	}
}
