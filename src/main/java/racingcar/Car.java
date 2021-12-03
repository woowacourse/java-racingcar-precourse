package racingcar;

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

	protected boolean isMoved() {
		return position != 0;
	}

	public int getPosition() {
		return position;
	}

	public String getName() {
		return name;
	}

	public boolean isSamePosition(int position) {
		return this.position == position;
	}
}
