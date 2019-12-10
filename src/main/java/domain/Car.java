package domain;

import static util.CustomErrorMessage.*;

public class Car {
	private final String name;
	private int position = 0;

	private int LENGTH_LIMIT = 5;

	public Car(String name) {
		validateNameLength(name);
		this.name = name;
	}

	private void validateNameLength(String name) {
		if (name.length() > LENGTH_LIMIT) {
			throw new IllegalArgumentException(NOT_PERMITTED_STRING_LENGTH);
		}
	}
}
