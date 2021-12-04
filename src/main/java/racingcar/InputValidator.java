package racingcar;

import java.util.HashSet;

public class InputValidator {
	private String carName;
	HashSet<String> carNameSet = new HashSet<>();

	public boolean isStrContainOnlyAlphabetOrComma(String str) {
		if (str.matches("[a-zA-z,]+")) {
			return true;
		}
		throw new IllegalArgumentException(ErrorMessage.ENGLISH_AND_COMMA_ONLY.get());
	}

	public boolean hasValidLengthAndNoDuplication(String carName) {
		this.carName = carName;
		return isValidLength() && hasNoDuplication();
	}

	private boolean isValidLength() {
		int len = carName.length();
		if (0 < len && len <= 5) {
			return true;
		}
		throw new IllegalArgumentException(ErrorMessage.NOT_ALLOWED_LENGTH_RANGE.get());
	}

	private boolean hasNoDuplication() {
		if (carNameSet.contains(carName)) {
			throw new IllegalArgumentException(ErrorMessage.DUPLICATION_NOT_ALLOWED.get());
		}
		carNameSet.add(carName);
		return true;
	}

	public boolean isIntegerGTE1(String str) {
		return isInteger(str) && isGreaterThan1(str);
	}

	private boolean isInteger(String str) {
		if (str.matches("[0-9]+")) {
			return true;
		}
		throw new IllegalArgumentException(ErrorMessage.INTEGER_ONLY_ALLOWED.get());
	}

	private boolean isGreaterThan1(String str) {
		int num = Integer.parseInt(str);
		if (1 <= num) {
			return true;
		}
		throw new IllegalArgumentException(ErrorMessage.SHOULD_BIGGER_THAN_1.get());
	}
}
