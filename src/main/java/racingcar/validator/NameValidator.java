package racingcar.validator;

import java.util.ArrayList;

public class NameValidator {

	private static final String NAME_ERROR_MESSAGE = "[ERROR] 적절하지 않은 자동차 이름 입력되었습니다.";

	private static final int NAME_LENGTH_MAX = 5;
	private static final int NAME_LENGTH_MIN = 1;

	public boolean validate(ArrayList<String> nameList) {
		try {
			for (String name : nameList) {
				keepLengthLimit(name);
			}

			return false;
		} catch (IllegalArgumentException illegalArgumentException) {
			System.out.println(NAME_ERROR_MESSAGE);

			return true;
		}
	}

	private void keepLengthLimit(String name) throws IllegalArgumentException {
		if (name.length() > NAME_LENGTH_MAX || name.length() < NAME_LENGTH_MIN) {
			throw new IllegalArgumentException();
		}
	}
}
