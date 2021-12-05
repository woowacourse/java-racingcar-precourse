package racingcar.service;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Stream;

public class ValidationService {
	public static final int MAX_NAME_LENGTH = 5;

	public static void checkCarNames(String names, String delimiter) {
		if (isEmpty(names)) {
			throw new IllegalArgumentException("자동차의 이름은 빈 문자열이 될 수 없습니다.");
		} else if (isEqualToDelimiter(names, delimiter)) {
			throw new IllegalArgumentException("쉼표(,)만 입력할 수 없습니다.");
		} else if (isSingleCarName(names, delimiter)) {
			throw new IllegalArgumentException("자동차의 이름이 한 개 뿐입니다.");
		}
	}

	public static boolean isEmpty(String names) {
		return names.isEmpty();
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

	public static void checkDuplicatedCarName(String[] carNames){
		if (hasDuplicatedCarName(carNames)) {
			throw new IllegalArgumentException("중복되는 자동차 이름을 입력할 수 없습니다.");
		}
	}

	public static void checkEachCarName(String[] carNames) {
		for (String name : carNames) {
			if (isEmpty(name)) {
				throw new IllegalArgumentException("자동차의 이름은 빈 문자열이 될 수 없습니다.");
			} else if (isInvalidCarNameLength(name)) {
				throw new IllegalArgumentException(String.format("자동차의 이름은 %d글자 이하여야 합니다.",
					MAX_NAME_LENGTH));
			}
		}
	}
}

