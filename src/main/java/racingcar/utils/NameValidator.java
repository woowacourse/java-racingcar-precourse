package racingcar.utils;

import java.util.ArrayList;
import java.util.HashSet;

public class NameValidator {
	public static final int NAME_LENGTH_LIMIT = 5;

	public static final String ERROR_ONLY_NAME = "[ERROR] 이름을 2개 이상 입력해주세요.";
	public static final String ERROR_LONG_NAME = "[ERROR] 이름을 5자 이하로 등록해주세요";
	public static final String ERROR_DUPLICATE_NAME = "[ERROR] 중복된 이름이 있습니다.";
	public static final String ERROR_EMPTY_NAME = "[ERROR] 빈 이름이 있습니다";

	public void validateNames(ArrayList<String> names) {
		isOnlyName(names);
		isLongName(names);
		isDuplicateName(names);
		isEmptyName(names);
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
		if (names.isEmpty()) {
			throw new IllegalArgumentException(ERROR_EMPTY_NAME);
		}
		for (String name : names) {
			if (name.isEmpty()) {
				throw new IllegalArgumentException(ERROR_EMPTY_NAME);
			}
		}
	}
}


