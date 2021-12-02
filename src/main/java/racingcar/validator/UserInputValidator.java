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

	public static void validateUserInputIterationNumberInteger(String userInputIterationNumber) {
		try {
			Integer.parseInt(userInputIterationNumber);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(NOT_A_INTEGER_ERROR_HINT.getString());
		}
	}

	public static void validateUserInputIterationNumberRange(String userInputIterationNumber) {
		if (ITERATION_NUMBER_MINIMUM.getValue() <= Integer.parseInt(userInputIterationNumber))
			return;
		throw new IllegalArgumentException(LENGTH_ERROR_HINT.getString());
	}
}
