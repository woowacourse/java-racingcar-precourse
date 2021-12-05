package racingcar.utils;

import java.util.List;
import java.util.Objects;

public class ExceptionUtils {

	private static final int CAR_NAME_MINIMUM_LENGTH = 0;
	private static final int CAR_NAME_MAXIMUM_LENGTH = 5;
	private static final int MINIMUM_NATURAL_NUMBER = 1;
	private static final int MAXIMUM_INT_VALUE = 2147483647;
	private static final String REGULAR_EXPRESSION_ONLY_NUMBER = "^[0-9]*$";
	private static final String ERROR_HEADER = "[ERROR] ";
	private static final String COMMA = ",";
	private static final String LENGTH_ERROR_MESSAGE = "잘못된 차량의 길이가 입력되었습니다.";
	private static final String DUPLICATE_ERROR_MESSAGE = "중복된 차량의 이름이 입력되었습니다.";
	private static final String SPACE_ERROR_MESSAGE = "공백이 입력되었습니다.";
	private static final String NUMBER_ERROR_MESSAGE = "시도 횟수에 문자가 입력되었습니다.";
	private static final String NATURAL_NUMBER_ERROR_MESSAGE = "시도 횟수는 자연수만 가능합니다.";
	private static final String OVER_RANGE_ERROR_MESSAGE = "최대 허용하는 정수값을 초과했습니다.";

	private ExceptionUtils() {
	}

	public static void validateCarNames(String inputCarNames, List<String> carNames) {
		if (!checkDuplicatedCarName(carNames)) {
			throw new IllegalArgumentException(ERROR_HEADER + DUPLICATE_ERROR_MESSAGE);
		}
		if (!checkCarNameNull(inputCarNames, carNames)) {
			throw new IllegalArgumentException(ERROR_HEADER + LENGTH_ERROR_MESSAGE);
		}
		for (String carName : carNames) {
			if (!checkCarNameLength(carName)) {
				throw new IllegalArgumentException(ERROR_HEADER + LENGTH_ERROR_MESSAGE);
			}
			if (!checkCarNameContainsSpace(carName)) {
				throw new IllegalArgumentException(ERROR_HEADER + SPACE_ERROR_MESSAGE);
			}
		}
	}

	public static int validateNumberOfAttempts(String inputNumber) {
		int numberOfAttempts;

		if (!checkNumberEmpty(inputNumber)) {
			throw new IllegalArgumentException(ERROR_HEADER + SPACE_ERROR_MESSAGE);
		}
		if (!checkNumber(inputNumber)) {
			throw new IllegalArgumentException(ERROR_HEADER + NUMBER_ERROR_MESSAGE);
		}
		if (!checkMaxValue(inputNumber)) {
			throw new IllegalArgumentException(ERROR_HEADER + OVER_RANGE_ERROR_MESSAGE);
		}
		numberOfAttempts = Integer.parseInt(inputNumber);
		if (!checkPositiveNumber(numberOfAttempts)) {
			throw new IllegalArgumentException(ERROR_HEADER + NATURAL_NUMBER_ERROR_MESSAGE);
		}
		return numberOfAttempts;
	}

	private static boolean checkCarNameLength(String carName) {
		return carName.length() > CAR_NAME_MINIMUM_LENGTH
			&& carName.length() <= CAR_NAME_MAXIMUM_LENGTH;
	}

	private static boolean checkDuplicatedCarName(List<String> carNames) {
		return carNames.stream().distinct().count() == carNames.size();
	}

	private static boolean checkCarNameNull(String inputCarNames, List<String> carNames) {
		return !carNames.isEmpty() && !inputCarNames.endsWith(COMMA);
	}

	private static boolean checkCarNameContainsSpace(String carName) {
		return Objects.equals(carName, carName.replace(" ", ""));
	}

	private static boolean checkNumberEmpty(String inputNumber) {
		return !inputNumber.isEmpty();
	}

	private static boolean checkNumber(String inputNumber) {
		return inputNumber.matches(REGULAR_EXPRESSION_ONLY_NUMBER);
	}

	private static boolean checkMaxValue(String inputNumber) {
		long longNumber;

		longNumber = Long.parseLong(inputNumber);
		return longNumber <= MAXIMUM_INT_VALUE;
	}

	private static boolean checkPositiveNumber(int numberOfAttempts) {
		return numberOfAttempts >= MINIMUM_NATURAL_NUMBER;
	}
}
