package racingcar.utils;

import static racingcar.utils.Constant.*;

public class Validator {
	public static void validateNameInput(String[] names) {
		for (String name : names) {
			if (name.trim().length() > NAME_LENGTH_LIMIT || name.trim().length() == 0) {
				throw new IllegalArgumentException(ERROR_LENGTH_MSG);
			}
		}
	}
}
