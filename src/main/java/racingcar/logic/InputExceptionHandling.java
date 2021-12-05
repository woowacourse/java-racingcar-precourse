package racingcar.logic;

import java.util.Arrays;

public class InputExceptionHandling {
	private static final String COUNT_ERROR_MSG = "하나 이상의 이름을 입력해야 한다.";
	private static final String LENGTH_ERROR_MSG = "이름은 5글자 이하여야 한다.";
	private static final String DUP_ERROR_MSG = "이름은 중복되지 않아야 한다.";
	private static final String SPACE_ERROR_MSG = "공백은 이름으로 설정할 수 없다.";
	private static final String SPACE_STRING = "";
	private static final int MAX_NAME_LENGTH = 5;
	private static final String GAME_COUNT_ERROR_MSG = "시도 횟수는 숫자여야 한다.";
	private static final String COUNT_RANGE_ERROR_MSG = "시도 횟수는 1 이상이어야 한다.";

	public String[] validNameInput(String[] names) throws IllegalArgumentException {
		validCount(names);
		validLength(names);
		validDuplication(names);
		validIsSpace(names);

		return names;
	}

	private void validCount(String[] names) throws IllegalArgumentException {
		if (names.length <= 0) {
			throw new IllegalArgumentException(COUNT_ERROR_MSG);
		}
	}

	private void validLength(String[] names) throws IllegalArgumentException {
		for (String name : names) {
			if (name.length() > MAX_NAME_LENGTH) {
				throw new IllegalArgumentException(LENGTH_ERROR_MSG);
			}
		}
	}

	private void validDuplication(String[] names) throws IllegalArgumentException {
		if (Arrays.stream(names).distinct().count() != names.length) {
			throw new IllegalArgumentException(DUP_ERROR_MSG);
		}
	}

	private void validIsSpace(String[] names) throws IllegalArgumentException {
		for (String name : names) {
			if (name.equals(SPACE_STRING)) {
				throw new IllegalArgumentException(SPACE_ERROR_MSG);
			}
		}
	}

	public int validCountInput(String count) {
		int intCount = transferToInt(count);
		validRange(intCount);

		return intCount;
	}

	private int transferToInt(String count) throws IllegalArgumentException {
		try {
			return Integer.parseInt(count);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(GAME_COUNT_ERROR_MSG);
		}
	}

	private void validRange(int count) throws IllegalArgumentException {
		if (count <= 0) {
			throw new IllegalArgumentException(COUNT_RANGE_ERROR_MSG);
		}
	}
}
