package racingcar.domain;

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
}
