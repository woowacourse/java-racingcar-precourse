package racingcar;

import static java.lang.String.*;

import org.assertj.core.util.Strings;

public class CarNameValidator {
	private static final int NAME_LENGTH_MAX = 5;
	private static final String NAME_LENGTH_ERROR = format("[ERROR] 자동차의 이름은 %d자를 초과할 수 없습니다.", NAME_LENGTH_MAX);
	private static final String NAME_EMPTY_ERROR = "[ERROR] 자동차의 이름은 공백일 수 없습니다.";

	private CarNameValidator() {
	}

	public static void validate(String name) {
		validateNotEmpty(name);
		validateLength(name);
	}

	private static void validateNotEmpty(String name) {
		if (Strings.isNullOrEmpty(name)) {
			throw new IllegalArgumentException(NAME_EMPTY_ERROR);
		}
	}

	private static void validateLength(String name) {
		if (name.length() > NAME_LENGTH_MAX) {
			throw new IllegalArgumentException(NAME_LENGTH_ERROR);
		}
	}
}
