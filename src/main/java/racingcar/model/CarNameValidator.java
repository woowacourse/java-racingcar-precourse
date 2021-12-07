package racingcar.model;

import java.util.ArrayList;
import java.util.regex.Pattern;

import racingcar.Constants;
import racingcar.Util;

public class CarNameValidator {
	private final String NAMES_STRING;
	public final ArrayList<String> NAMES;

	public CarNameValidator(String namesString) {
		this.NAMES_STRING = namesString;
		this.NAMES = Util.toArrayList(namesString);
		validate();
	}

	public void validate() {
		isRightNameString();
		isNotDuplicate();
		isRightNameSize();
	}

	public void isRightNameString() {
		// String 형식 확인: 앞&뒤-문자, 중간-문자&구분자
		if (!Pattern.matches("^[가-힣\\w]+[가-힣\\w" + Constants.DELIMITER + "]*[가-힣\\w]$", NAMES_STRING)) {
			throw new IllegalArgumentException(Constants.CAR_NAME_WRONG_ERROR);
		}
	}

	public void isRightNameSize() {
		if (NAMES.stream().anyMatch(name -> name.isEmpty() || name.length() > Constants.NAME_SIZE)) {
			throw new IllegalArgumentException(Constants.CAR_NAME_SIZE_ERROR);
		}
	}

	public void isNotDuplicate() {
		if (NAMES.size() != NAMES.stream().distinct().count()) {
			throw new IllegalArgumentException(Constants.CAR_NAME_DUPLICATE_ERROR);
		}
	}
}
