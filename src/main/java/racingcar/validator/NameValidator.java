package racingcar.validator;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class NameValidator {

	private static final int NAME_LENGTH_MAX = 5;
	private static final int NAME_LENGTH_MIN = 1;

	private static final String LENGTH_LIMIT_ERROR_MESSAGE = "[ERROR] 이름의 길이는 1 ~ 5자 까지만 허용합니다.";
	private static final String NOT_ONLY_BLANK_ERROR_MESSAGE = "[ERROR] 이름이 공백으로만 이루어져 있으면 안 됩니다.";
	private static final String UNIQUE_NAME_ERROR_MESSAGE = "[ERROR] 중복되는 이름이 존재하면 안 됩니다.";

	private String errorMessage = null;

	public boolean validate(ArrayList<String> nameList) {
		try {
			keepUniqueName(nameList);
			for (String name : nameList) {
				keepNotOnlyBlank(name);
				keepLengthLimit(name);
			}

			return false;
		} catch (IllegalArgumentException illegalArgumentException) {
			System.out.println(errorMessage);

			return true;
		}
	}

	private void keepLengthLimit(String name) throws IllegalArgumentException {
		if (name.length() > NAME_LENGTH_MAX || name.length() < NAME_LENGTH_MIN) {
			errorMessage = LENGTH_LIMIT_ERROR_MESSAGE;

			throw new IllegalArgumentException();
		}
	}

	private void keepNotOnlyBlank(String name) throws IllegalArgumentException {
		if (name.length() >= NAME_LENGTH_MIN && name.trim().length() == 0) {
			errorMessage = NOT_ONLY_BLANK_ERROR_MESSAGE;

			throw new IllegalArgumentException();
		}
	}

	private void keepUniqueName(ArrayList<String> nameList) throws IllegalArgumentException {
		int distinctListSize = nameList.stream().distinct().collect(Collectors.toList()).size();

		if (nameList.size() != distinctListSize) {
			errorMessage = UNIQUE_NAME_ERROR_MESSAGE;

			throw new IllegalArgumentException();
		}
	}
}
