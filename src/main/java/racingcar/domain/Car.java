package racingcar.domain;

public class Car {
	public static final int MINIMUM_CAR_NAME_LENGTH = 1;
	public static final int MAXIMUM_CAR_NAME_LENGTH = 5;
	private static final int MINIMUM_DRIVE_CONDITION = 4;

	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	public void drive(int value) {
		if (MINIMUM_DRIVE_CONDITION <= value) {
			this.position++;
		}
	}

	public boolean isSamePosition(int value) {
		return this.position == value;
	}

	public int getPosition() {
		return position;
	}

	public String getName() {
		return name;
	}
}
