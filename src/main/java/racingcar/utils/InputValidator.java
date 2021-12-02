package racingcar.utils;

import java.util.ArrayList;
import java.util.HashSet;

import camp.nextstep.edu.missionutils.Console;

public class InputValidator {
	public static final int NAME_LENGTH_LIMIT = 5;

	public static final String ERROR_ONLY_NAME = "[ERROR] 이름을 2개 이상 입력해주세요.";
	public static final String ERROR_LONG_NAME = "[ERROR] 이름을 5자 이하로 등록해주세요";
	public static final String ERROR_DUPLICATE_NAME = "[ERROR] 중복된 이름이 있습니다.";
	public static final String ERROR_EMPTY_NAME = "[ERROR] 빈 이름이 있습니다";
	public static final String ERROR_NOT_INTEGER = "[ERROR] 이동횟수는 숫자여야 합니다.";
	public static final String ERROR_ZERO_OR_NEGATIVE = "[ERROR] 이동횟수는 양수인 정수여야 합니다.";

	public boolean validateNames(ArrayList<String> names) {
		try {
			isOnlyName(names);
			isLongName(names);
			isDuplicateName(names);
			isEmptyName(names);
			return false;
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			return true;
		}
	}

	private void isOnlyName(ArrayList<String> names) {
		if (names.size() == 1) {
			throw new IllegalArgumentException(ERROR_ONLY_NAME);
		}
	}

	private void isLongName(ArrayList<String> names) {
		for (String name : names) {
			if (name.length() > NAME_LENGTH_LIMIT) {
				throw new IllegalArgumentException(ERROR_LONG_NAME);
			}
		}
	}

	private void isDuplicateName(ArrayList<String> names) {
		HashSet<String> duplicateCheckSet = new HashSet<>();
		for (String name : names) {
			duplicateCheckSet.add(name);
		}
		if (duplicateCheckSet.size() != names.size()) {
			throw new IllegalArgumentException(ERROR_DUPLICATE_NAME);
		}
	}

	private void isEmptyName(ArrayList<String> names) {
		for (String name : names) {
			if (name.trim().isEmpty()) {
				throw new IllegalArgumentException(ERROR_EMPTY_NAME);
			}
		}
	}

	public boolean validateMove(String inputValue) {
		try {
			isInteger(inputValue);
			isPositive(inputValue);
			return false;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return true;
		}
	}

	private void isInteger(String inputValue) {
		for (int i = 0; i < inputValue.length(); i++) {
			if (!Character.isDigit(inputValue.charAt(i))) {
				throw new IllegalArgumentException(ERROR_NOT_INTEGER);
			}
		}
	}

	private void isPositive(String inputValue) {
		int value = Integer.parseInt(inputValue);
		if (value <= 0) {
			throw new IllegalArgumentException(ERROR_ZERO_OR_NEGATIVE);
		}
	}
}
