package racingcar.utils.validator;

import java.util.Arrays;
import java.util.stream.Stream;

import racingcar.messages.ErrorMessages;

public class GameTimesValidator {
	public boolean isInvalidTimes(String times) {
		String[] timesArray = times.split("");
		try {
			if (isEmptyString(timesArray)) {
				throw new IllegalArgumentException(ErrorMessages.ERROR + ErrorMessages.EMPTY_TIMES);
			}
			if (isContainNotNumber(timesArray)) {
				throw new IllegalArgumentException(ErrorMessages.ERROR + ErrorMessages.NOT_NUMBER);
			}
			if (isZeroTimes(times)) {
				throw new IllegalArgumentException(ErrorMessages.ERROR + ErrorMessages.ZERO_TIMES);
			}
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			return true;
		}
		return false;
	}



	private boolean isEmptyString(String[] timesArray) {
		return Arrays.stream(timesArray)
			.anyMatch(character -> character.isEmpty());
	}

	private boolean isContainNotNumber(String[] timesArray) {
		return Arrays.stream(timesArray)
			.anyMatch(character -> character.charAt(0) < '0' || character.charAt(0) > '9');
	}

	private boolean isZeroTimes(String times) {
		if (Integer.parseInt(times) == 0) {
			return true;
		}
		return false;
	}
}
