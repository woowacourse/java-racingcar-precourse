package racingcar.validation;

import java.util.HashSet;

public class CarNamesValidator {
	private static final int CAR_NAME_MAX_LENGTH = 5;
	private static final int CAR_NAME_MIN_LENGTH = 1;
	private static final String ERROR_MESSAGE = "[ERROR] ";
	private static final String NAME_LENGTH_RANGE_MESSAGE = "이름은 5자 이하(최소 1자)만 가능하다.";
	private static final String NAME_NOT_DISTINCT_MESSAGE = "중복된 이름을 입력할 수 없다.";
	private static final String NO_EXIST_NAME_MESSAGE = "이름을 입력해주세요.";
	private String[] names;

	public boolean isValidNamesInput(String[] names) {
		this.names = names;
		try {
			validateBlankNames();
			validateExistNames();
			validateNameLengthInRange();
			validateNamesDistinct();
		} catch (IllegalArgumentException e) {
			System.out.println(e);
			return false;
		}
		return true;
	}

	private void validateNameLengthInRange() {
		for (String name : names) {
			if (name.length() > CAR_NAME_MAX_LENGTH || name.length() < CAR_NAME_MIN_LENGTH) {
				throw new IllegalArgumentException(ERROR_MESSAGE + NAME_LENGTH_RANGE_MESSAGE);
			}
		}
	}

	private void validateNamesDistinct() {
		HashSet<String> hashSet = new HashSet<>();
		for (String name : names) {
			hashSet.add(name);
		}
		if (hashSet.size() != names.length) {
			throw new IllegalArgumentException(ERROR_MESSAGE + NAME_NOT_DISTINCT_MESSAGE);
		}
	}

	private void validateExistNames() {
		if (names.length == 0) {
			throw new IllegalArgumentException(ERROR_MESSAGE + NO_EXIST_NAME_MESSAGE);
		}
	}

	private void validateBlankNames() {
		for (String name : names) {
			name = name.replace(" ", "");
			if (name.length() == 0) {
				throw new IllegalArgumentException(ERROR_MESSAGE + NO_EXIST_NAME_MESSAGE);
			}
		}
	}

}
