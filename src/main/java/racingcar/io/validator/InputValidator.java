package racingcar.io.validator;

import java.util.Collections;
import java.util.List;

import racingcar.GameData;
import racingcar.exception.NameContainsEmptyStringException;
import racingcar.exception.NameDuplicatedException;
import racingcar.exception.NameLengthException;
import racingcar.exception.TurnCountNotIntegerException;
import racingcar.exception.TurnCountTooSmallException;

public class InputValidator {

	public static void validateNameLength(List<String> nameList) {
		for (String name : nameList) {
			if (name.length() > GameData.CARNAME_LIMIT) {
				throw new NameLengthException(GameData.CARNAME_LIMIT_ERROR_MESSAGE);
			}
		}
	}

	public static void validateNameIsDuplicated(List<String> nameList) {
		for (String name : nameList) {
			if (Collections.frequency(nameList, name) != 1) {
				throw new NameDuplicatedException(GameData.CARNAME_DUPLICATED_ERROR_MESSAGE);
			}
		}
	}

	public static void validateNameContatainsEmptyString(List<String> nameList) {
		for (String name : nameList) {
			if (name.isEmpty() || name.matches(GameData.CARNAME_CHECK_REGEX)) {
				throw new NameContainsEmptyStringException(GameData.CARNAME_EMPTY_ERROR_MESSAGE);
			}
		}
	}

	public static void validateTurnCountIsInteger(String turnCount) {
		try {
			Integer.parseInt(turnCount);
		} catch (NumberFormatException nfe) {
			throw new TurnCountNotIntegerException(GameData.TURNCOUNT_NOT_INTEGER_ERROR_MESSAGE, nfe);
		}
	}

	public static void validateTurnCountNotTooSmall(int turnCount) {
		if (turnCount <= 0) {
			throw new TurnCountTooSmallException(GameData.TURNCOUNT_TOO_SMALL_ERROR_MESSAGE);
		}
	}
}
