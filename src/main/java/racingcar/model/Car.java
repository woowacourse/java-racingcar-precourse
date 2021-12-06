package racingcar.model;

public class Car {
	private final int STANDARD_OF_MOVE = 4;
	private final String POSITION_BY_FORMATTER = "-";

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

	public void move(int number) {
		if (number >= STANDARD_OF_MOVE) {
			position++;
		}
	}

	public boolean isMaxPosition(int maxPosition) {
		return maxPosition == position;
	}

	@Override
	public String toString() {
		StringBuilder positionLine = new StringBuilder();
		for (int i = 0; i < position; i++) {
			positionLine.append(POSITION_BY_FORMATTER);
		}
		return name + " : " + positionLine;
	}
}
