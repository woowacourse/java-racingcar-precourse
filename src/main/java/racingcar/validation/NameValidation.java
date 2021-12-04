package racingcar.validation;

import static racingcar.message.GuideMessage.*;

import java.util.Arrays;

public class NameValidation {

	public static final int MAXIMUM_LENGTH = 5;
	public static final int EMPTY_STRING = 0;

	public static void validateName(String[] nameList) {
		validateDuplication(nameList);
		validateLength(nameList);
	}

	private static void validateDuplication(String[] nameList) {
		if (Arrays.stream(nameList)
			.distinct()
			.count() != nameList.length) {
			throw new IllegalArgumentException(ERR_NAME_DUPLICATION);
		}
	}

	private static void validateLength(String[] nameList) {
		if (Arrays.stream(nameList)
			.anyMatch(name -> name.length() == EMPTY_STRING || name.length() > MAXIMUM_LENGTH)) {
			throw new IllegalArgumentException(ERR_NAME_LENGTH);
		}
	}
}
