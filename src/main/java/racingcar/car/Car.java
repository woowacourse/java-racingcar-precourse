package racingcar.car;

public class Car {
	private static final String MOVEMENT = "-";
	private static final char COLON = ':';
	private static final char SPACE = ' ';

	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	public void moveForward() {
		position++;
	}

	public String positionToString() {
		StringBuilder stringBuilder = new StringBuilder(name + SPACE + COLON + SPACE);
		for (int i = 0; i < this.position; i++) {
			stringBuilder.append(MOVEMENT);
		}
		return stringBuilder.toString();
	}
}
