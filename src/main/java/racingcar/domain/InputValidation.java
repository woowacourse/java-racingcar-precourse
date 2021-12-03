package racingcar.domain;

import java.util.Arrays;

public class InputValidation {

	public static final long ZERO = 0;
	public static final int CAR_NAME_LENGTH_MIN = 1;
	public static final int CAR_NAME_LENGTH_MAX = 5;
	public static final long CAR_NUM_MIN = 1;
	public static final long CAR_NUM_MAX = 1000;
	public static final String ERROR_CAR_NAME_LENGTH = "[ERROR] 자동차 이름은 1자 이상 5자 이하만 가능합니다.";
	public static final String ERROR_CAR_NUMBER = "[ERROR] 자동차 개수는 1개 이상 1,000개 이하만 가능합니다.";
	public static final String ERROR_LAST_CHARACTER_REGEX = "[ERROR] 입력한 자동차 이름은 쉼표로 끝날 수 없습니다.";

	public static void checkCarNameValidation(String input, String splitRegex) {
		long carNameLengthValidation = Arrays.stream(input.split(splitRegex))
			.filter(carName -> carName.length() > CAR_NAME_LENGTH_MAX || carName.length() < CAR_NAME_LENGTH_MIN)
			.count();
		long carNumberValidation = Arrays.stream(input.split(splitRegex)).count();
		boolean lastCharacterRegex = input.endsWith(splitRegex);

		checkCarNameConditions(carNameLengthValidation, carNumberValidation, lastCharacterRegex);
	}

	public static void checkCarNameConditions(long carNameLengthValidation, long carNumberValidation,
		boolean lastCharacterRegex) {
		if (carNameLengthValidation != ZERO) {
			throw new IllegalArgumentException(ERROR_CAR_NAME_LENGTH);
		}
		if (carNumberValidation < CAR_NUM_MIN) {
			throw new IllegalArgumentException(ERROR_CAR_NUMBER);
		}
		if (carNumberValidation > CAR_NUM_MAX) {
			throw new IllegalArgumentException(ERROR_CAR_NUMBER);
		}
		if (lastCharacterRegex) {
			throw new IllegalArgumentException(ERROR_LAST_CHARACTER_REGEX);
		}
	}
}
