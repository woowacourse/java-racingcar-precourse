package racingcar.validator;

import static racingcar.constant.GameConstants.UserInput.*;
import static racingcar.constant.GameConstants.UserInputException.*;

public class UserInputValidator {
	public static void validateUserInputNameLength(String userInputName) {
		if (NAME_MINIMUM_LENGTH.getValue() <= userInputName.length()
			&& userInputName.length() <= NAME_MAXIMUM_LENGTH.getValue())
			return;
		throw new IllegalArgumentException(LENGTH_ERROR_HINT.getString());
	}
}
