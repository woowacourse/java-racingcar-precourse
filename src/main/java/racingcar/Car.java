package racingcar;

public class Car {
	public static int maxPosition = 0;
	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public int getPosition() {
		return this.position;
	}

	public void moveForward() {
		this.position++;
		updateMaxPosition();
	}

	private void updateMaxPosition() {
		if (this.position > maxPosition) {
			maxPosition = this.position;
		}
	}

	public boolean isMaxPosition() {
		return this.position == maxPosition;
	}
}
