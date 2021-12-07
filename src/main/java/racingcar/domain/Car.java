package racingcar.domain;

public class Car {
	private static final int FORWARD_THRESHOLD_NUMBER = 4;
	private final String name;
	private int position = 0;
	private CarPosition carPosition;

	public Car(String name) {
		this.name = name;
		carPosition = new CarPosition(position);
	}

	public static boolean isForward(int randNo) {
		return randNo >= FORWARD_THRESHOLD_NUMBER;
	}

	public CarPosition getPosition() {
		return carPosition;
	}

	public String getName() {
		return this.name;
	}

	public void forward() {
		carPosition = carPosition.forward();
	}

	public boolean isMaxPosition(int max) {
		return carPosition.equals(new CarPosition(max));
	}
}
