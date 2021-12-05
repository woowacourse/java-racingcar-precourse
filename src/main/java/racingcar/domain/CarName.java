package racingcar.domain;

import racingcar.enums.DomainConditions;

public class CarName {
	private static final int MAX_CAR_NAME_LENGTH = DomainConditions.MAX_CAR_NAME_LENGTH.get();
	private static final int EMPTY_CAR_NAME_LENGTH = DomainConditions.EMPTY_CAR_NAME_LENGTH.get();
	private static final String LONG_LENGTH_ERROR_MESSAGE = "[ERROR] "
		+ MAX_CAR_NAME_LENGTH
		+ "자 이하로 입력해주세요.";
	private static final String EMPTY_LENGTH_ERROR_MESSAGE = "[ERROR] 빈 자동차 이름이 입력되었습니다.";

	private String name;

	public CarName(String name) {
		validateRange(name);
		this.name = name;
	}

	public String get() {
		return name;
	}

	private void validateRange(String name) {
		int nameLength = name.length();
		if (nameLength > MAX_CAR_NAME_LENGTH) {
			throw new IllegalArgumentException(LONG_LENGTH_ERROR_MESSAGE);
		}
		if (nameLength == EMPTY_CAR_NAME_LENGTH) {
			throw new IllegalArgumentException(EMPTY_LENGTH_ERROR_MESSAGE);
		}
	}
}
