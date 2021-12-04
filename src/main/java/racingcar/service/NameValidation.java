package racingcar.service;

import static racingcar.message.GuideMessage.*;

import java.util.Arrays;

public class NameValidation {

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
			.anyMatch(name -> name.length() == 0 || name.length() > 5)) {
			throw new IllegalArgumentException(ERR_NAME_LENGTH);
		}
	}
}
