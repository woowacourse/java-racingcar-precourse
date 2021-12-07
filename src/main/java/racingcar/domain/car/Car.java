package racingcar.domain.car;

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
}
