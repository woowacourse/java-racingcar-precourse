package racingcar.utils.validator;

import java.util.Arrays;
import java.util.HashSet;

import racingcar.messages.ErrorMessages;

public class CarNameValidator {
	private static final int NAME_LIMIT_LENGTH = 5;

	public boolean isInvalidName(String[] carArray) {
		try {
			if (isEmptyName(carArray)) {
				throw new IllegalArgumentException(ErrorMessages.ERROR + ErrorMessages.EMPTY_NAME);
			}
			if (isInvalidLength(carArray)) {
				throw new IllegalArgumentException(ErrorMessages.ERROR + ErrorMessages.INVALID_LENGTH);
			}
			if (existsDuplicateName(carArray)) {
				throw new IllegalArgumentException(ErrorMessages.ERROR + ErrorMessages.DUPLICATE_NAME);
			}
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			return true;
		}
		return false;
	}

	private boolean isEmptyName(String[] carArray) {
		return !Arrays.stream(carArray)
			.allMatch(car -> car.length() > 0);
	}

	private boolean isInvalidLength(String[] carArray) {
		return Arrays.stream(carArray)
			.anyMatch(car -> car.length() > NAME_LIMIT_LENGTH);
	}

	private boolean existsDuplicateName(String[] carArray) {
		return !Arrays.stream(carArray)
			.allMatch(new HashSet<>()::add);
	}
}
