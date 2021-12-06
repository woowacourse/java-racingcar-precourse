package racingcar.service;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Stream;

public class ValidationService {
	private static final int MAX_NAME_LENGTH = 5;

	public static void checkCarNames(String names, String delimiter) {
		if (names.isEmpty()) {
			throw new IllegalArgumentException("자동차의 이름은 빈 문자열이 될 수 없습니다.");
		} else if (isEqualToDelimiter(names, delimiter)) {
			throw new IllegalArgumentException("쉼표(,)만 입력할 수 없습니다.");
		} else if (isSingleCarName(names, delimiter)) {
			throw new IllegalArgumentException("자동차의 이름이 한 개 뿐입니다.");
		}
	}

	public static void checkDuplicatedCarName(String[] carNames) {
		if (hasDuplicatedCarName(carNames)) {
			throw new IllegalArgumentException("중복되는 자동차 이름을 입력할 수 없습니다.");
		}
	}

	public static void checkEachCarName(String[] carNames) {
		for (String name : carNames) {
			if (name.isEmpty()) {
				throw new IllegalArgumentException("자동차의 이름은 빈 문자열이 될 수 없습니다.");
			} else if (isInvalidCarNameLength(name)) {
				throw new IllegalArgumentException(String.format("자동차의 이름은 %d글자 이하여야 합니다.",
					MAX_NAME_LENGTH));
			}
		}
	}

	public static void checkTryNumberIsValid(String number) {
		if (number.isEmpty()) {
			throw new IllegalArgumentException("시도 횟수를 입력하지 않았습니다.");
		} else if (isNotDigit(number)) {
			// "1000000000000"과 같은 정수 범위 밖의 입력은 숫자로 취급하지 않는다.
			throw new IllegalArgumentException("시도 횟수가 숫자가 아니거나 정수 범위 밖의 입력입니다.");
		}
		checkTryNumberIsValidDigit(Integer.parseInt(number));
	}

	private static void checkTryNumberIsValidDigit(int number) {
		if (isNotPositive(number)) {
			throw new IllegalArgumentException("시도 횟수는 0 또는 음수가 될 수 없습니다.");
		}
	}

	private static boolean isEqualToDelimiter(String target, String delimiter) {
		return Objects.equals(target, delimiter);
	}

	private static boolean isSingleCarName(String carNames, String delimiter) {
		return !carNames.contains(delimiter);
	}

	private static boolean isInvalidCarNameLength(String name) {
		return MAX_NAME_LENGTH < name.length();
	}

	private static boolean hasDuplicatedCarName(String[] names) {
		return Stream.of(names).distinct().count() != names.length;
	}

	private static boolean isNotDigit(String number) {
		try {
			Integer.parseInt(number);
		} catch (NumberFormatException e) {
			return true;
		}
		return false;
	}

	private static boolean isNotPositive(int number) {
		return number < 1;
	}
}

