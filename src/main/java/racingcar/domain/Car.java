package racingcar.domain;

public class Car {
	private final String name;
	private int position = 0;

	private Car(String name) {
		this.name = name;
	}

	public void goForward() {
		this.position++;
	}

	public static Car create(String name) {
		return new Car(name);
	}

	public int getPosition() {
		return position;
	}

	public String getName() {
		return name;
	}
}
