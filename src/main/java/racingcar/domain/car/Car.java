package racingcar.domain.car;

import racingcar.domain.movement.MovementStrategy;

public class Car {

	private final Name name;
	private final Position position;

	public Car(String name) {
		this(new Name(name), new Position());
	}

	public Car(Name name, Position position) {
		this.name = name;
		this.position = position;
	}

	public String getName() {
		return name.toString();
	}

	public void move(MovementStrategy strategy) {
		position.move(strategy);
	}

	@Override
	public String toString() {
		return String.format("%s : %s", getName(), position.toString());
	}
}
