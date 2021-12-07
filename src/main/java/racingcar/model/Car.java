package racingcar.model;

public class Car {
	private final String name;
	private int position = 0;

	public Car(String name) throws IllegalArgumentException {
		validateName(name);
		this.name = name;
	}
	
	private static void validateName(String name) throws IllegalArgumentException {
		if (name.isEmpty() || name.length() > 5) {
			throw new IllegalArgumentException();
		}
	}

	public void move() {
		position++;
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}
}
