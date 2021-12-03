package racingcar.domain;

public class Car {
	private static final int MINIMUM_DRIVE_CONDITION = 4;

	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	private void drive(int value) {
		if (MINIMUM_DRIVE_CONDITION <= value) {
			this.position++;
		}
	}
}
