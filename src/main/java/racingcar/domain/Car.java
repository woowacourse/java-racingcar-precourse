package racingcar.domain;

public class Car {
	private static final int FORWARD_THRESHOLD_NUMBER = 4;
	private final String name;
	private int position = 0;
	private CarPosition carPosition = new CarPosition(position);

	public Car(String name) {
		this.name = name;
	}

	public static boolean isForward(int randNo) {
		return randNo >= FORWARD_THRESHOLD_NUMBER;
	}

	public int getPosition() {
		return carPosition.getPosition();
	}

	public String getName() {
		return this.name;
	}

	public void forward() {
		carPosition = new CarPosition(carPosition.getPosition() + 1);
	}

}
