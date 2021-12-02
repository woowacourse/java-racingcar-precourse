package racingcar.model;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class CarNameValidation {
	private final String namesString;
	private final ArrayList<String> names;

	public CarNameValidation(String namesString) {
		this.namesString = namesString;
		this.names = Util.toNameArray(namesString);
	}

	public void validate() {
		isRightNameString();
		isNotDuplicate();
		isRightNameSize();
	}

	public void isRightNameSize() {
		if (names.stream()
			.allMatch(name -> !name.isEmpty() && name.length() <= Constants.NAME_SIZE)) {
			return;
		}
		throw new IllegalArgumentException(Constants.CAR_NAME_SIZE_ERROR);
	}

	public void isRightNameString() {
		if (isNameOrRest() && !namesString.isEmpty() && namesString.charAt(namesString.length() - 1) != ',') {
			return;
		}
		throw new IllegalArgumentException(Constants.CAR_NAME_WRONG_ERROR);
	}

	public void isNotDuplicate() {
		if (names.size() == names.stream().distinct().count()) {
			return;
		}
		throw new IllegalArgumentException(Constants.CAR_NAME_DUPLICATE_ERROR);
	}

	public boolean isNameOrRest() {
		String pattern = "^[가-힣\\w][가-힣\\w,]*$"; //한글, 영어, 숫자, 쉼표만 됨
		return Pattern.matches(pattern, namesString);
	}
}
