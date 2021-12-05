package racingcar;

import java.util.HashSet;

public class InputValidator {
	private static final int CAR_NAME_MAX_LENGTH = 5;
	private static final int CAR_NAME_MIN_LENGTH = 1;
	private static final int MIN_ROUND_NUMBER = 1;
	private static final String ERROR_MESSAGE = "[ERROR] ";
	private static final String NAME_LENGTH_RANGE_MESSAGE = "이름은 5자 이하만 가능하다.";
	private static final String NAME_NOT_DISTINCT_MESSAGE = "중복된 이름을 입력할 수 없다.";
	private static final String NOT_DIGIT_MESSAGE = "숫자가 아닌 문자는 입력할 수 없다.";
	private static final String ROUND_LESS_THAN_MIN_MESSAGE = "1보다 큰 수를 입력해야한다.";

	public boolean isValidNamesInput(String[] names) {
		try {
			validateNameLengthInRange(names);
			validateNamesDistinct(names);
		} catch (IllegalArgumentException e) {
			System.out.println(e);
			return false;
		}
		return true;
	}

	public boolean isValidNumberInput(String roundNumber) {
		try {
			validateNumberInput(roundNumber);
			validateNumberInRange(roundNumber);
		} catch (IllegalArgumentException e) {
			System.out.println(e);
			return false;
		}
		return true;
	}

	public void validateNameLengthInRange(String[] names) {
		for (int i = 0; i < names.length; i++) {
			if (names[i].length() > CAR_NAME_MAX_LENGTH || names[i].length() < CAR_NAME_MIN_LENGTH) {
				throw new IllegalArgumentException(ERROR_MESSAGE + NAME_LENGTH_RANGE_MESSAGE);
			}
		}
	}

	public void validateNamesDistinct(String[] names) {
		HashSet<String> hashSet = new HashSet<>();
		for (int i = 0; i < names.length; i++) {
			hashSet.add(names[i]);
		}
		if (hashSet.size() != names.length) {
			throw new IllegalArgumentException(ERROR_MESSAGE + NAME_NOT_DISTINCT_MESSAGE);
		}
	}

	public void validateNumberInput(String number) {
		if (number.chars().allMatch(Character::isDigit) == false) {
			throw new IllegalArgumentException(ERROR_MESSAGE + NOT_DIGIT_MESSAGE);
		}
	}

	public void validateNumberInRange(String number) {
		if (Integer.parseInt(number) < MIN_ROUND_NUMBER) {
			throw new IllegalArgumentException(ERROR_MESSAGE + ROUND_LESS_THAN_MIN_MESSAGE);
		}
	}
}
