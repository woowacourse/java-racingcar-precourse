package racingcar.domain.car;

import racingcar.utils.StringUtils;

public class Name {
	private static final String ERROR_EMPTY = "이름은 빈 문자열일 수 없습니다.";
	private static final String ERROR_TOO_LONG = String.format("이름은 %d자를 초과할 수 없습니다.", Name.MAX_SIZE);

	public static final int MAX_SIZE = 5;

	private final String name;

	public Name(String name) {
		validateName(name);
		this.name = name;
	}

	private void validateName(String name) {
		validateBlank(name);
		validateLength(name);
	}

	private void validateBlank(String name) {
		if (StringUtils.isBlank(name)) {
			throw new IllegalArgumentException(ERROR_EMPTY);
		}
	}

	private void validateLength(String name) {
		if (name.length() > MAX_SIZE) {
			throw new IllegalArgumentException(ERROR_TOO_LONG);
		}
	}

	@Override
	public String toString() {
		return name;
	}
}
