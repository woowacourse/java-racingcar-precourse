package racingcar;

public class Car {
	private static final int CAN_GO_NUM = 4;

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

	public void moveOrStop(int randomNum) {
		if (canMove(randomNum)) {
			move();
		}
	}

	private void move() {
		position++;
	}

	private boolean canMove(int randomNum) {
		return randomNum >= CAN_GO_NUM;
	}

	protected boolean isMoved() {
		return position != 0;
	}

	public int getPosition() {
		return position;
	}

	public boolean isSamePosition(int position) {
		return this.position == position;
	}
}
