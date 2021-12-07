package racingcar.racing.domain;


public class Car {
	private final String name;
	private int position = 0;

	public Car(String name) {

		this.name = name;
	}

	public void moveForward() {
		position++;
	}

	public String getName() {

		return name;
	}

	public int getPosition() {

		return position;
	}

}
