package racingcar.validator;

import java.util.ArrayList;

public class NameValidator {

	private static final int NAME_LENGTH_MAX = 5;
	private static final int NAME_LENGTH_MIN = 1;

	public void validate(ArrayList<String> nameList) throws IllegalArgumentException {
		for (String name : nameList) {
			keepLengthLimit(name);
		}
	}

	private void keepLengthLimit(String name) throws IllegalArgumentException {
		if (name.length() > NAME_LENGTH_MAX || name.length() < NAME_LENGTH_MIN) {
			throw new IllegalArgumentException();
		}
	}
}
