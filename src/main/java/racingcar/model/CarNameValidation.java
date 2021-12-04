package racingcar.model;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class CarNameValidation {
	private final String NAMES_STRING;
	private final ArrayList<String> NAMES;

	public CarNameValidation(String namesString) {
		this.NAMES_STRING = namesString;
		this.NAMES = Util.toNameArray(namesString);
	}

	public void validate() {
		isRightNameString();
		isNotDuplicate();
		isRightNameSize();
	}

	public void isRightNameSize() {
		if (NAMES.stream()
			.allMatch(name -> !name.isEmpty() && name.length() <= Constants.NAME_SIZE)) {
			return;
		}
		throw new IllegalArgumentException(Constants.CAR_NAME_SIZE_ERROR);
	}

	public void isRightNameString() {
		if (isNameOrRest() && !NAMES_STRING.isEmpty() && NAMES_STRING.charAt(NAMES_STRING.length() - 1) != ',') {
			return;
		}
		throw new IllegalArgumentException(Constants.CAR_NAME_WRONG_ERROR);
	}

	public void isNotDuplicate() {
		if (NAMES.size() == NAMES.stream().distinct().count()) {
			return;
		}
		throw new IllegalArgumentException(Constants.CAR_NAME_DUPLICATE_ERROR);
	}

	public boolean isNameOrRest() {
		String pattern = "^[가-힣\\w][가-힣\\w,]*$"; //한글, 영어, 숫자, 쉼표만 됨
		return Pattern.matches(pattern, NAMES_STRING);
	}
}
