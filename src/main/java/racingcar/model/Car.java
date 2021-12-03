package racingcar.model;

public class Car {
	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	public int getPosition() {
		return position;
	}

	public String getName() {
		return name;
	}

	public void go() {
		position++;
	}

	public void stop() {

	}

	@Override
	public String toString() {
		String positionLine = "";
		for (int i = 0; i < position; i++) {
			positionLine += "-";
		}
		return name + " : " + positionLine;
	}
}
