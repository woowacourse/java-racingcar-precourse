package domain;

import static util.CustomErrorMessage.*;

import java.util.Comparator;

public class Car {
	private String name;
	private int position = 0;
	private int railId;

	private static final int MOVE_CONDITION_NUMBER = 4;
	private static final int LENGTH_LIMIT = 5;

	private static final String DASH_LOAD = "-";
	private static final String PRINT_FORMAT = ":";

	public Car(final String name, final int railId) {
		validateNameLength(name);
		this.name = name;
		this.railId = railId;
	}

	private void validateNameLength(final String name) {
		if (name.length() > LENGTH_LIMIT) {
			throw new IllegalArgumentException(NOT_PERMITTED_STRING_LENGTH);
		}
	}

	private String getPositionAsGUI() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < position; i++) {
			sb.append(DASH_LOAD);
		}
		return sb.toString();
	}

	String getPositionWithRacingFormat() {
		return name + PRINT_FORMAT + getPositionAsGUI();
	}

	void tryMove(int conditionNumber) {
		if (conditionNumber >= MOVE_CONDITION_NUMBER)
			moveCarPosition();
	}

	private void moveCarPosition() {
		position++;
	}

	public static class CarComparator implements Comparator<Car> {
		@Override
		public int compare(Car car1, Car car2) {
			if (car1.position > car2.position)
				return 1;
			else if (car1.position == car2.position)
				return 0;
			return -1;
		}
	}

	public int getPosition() {
		return position;
	}

	public int getRailId() {
		return railId;
	}

	public String getName() {
		return name;
	}
}
