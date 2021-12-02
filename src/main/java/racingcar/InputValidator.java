package racingcar;

import java.util.HashSet;

public class InputValidator {
	private String carName;
	HashSet<String> carNameSet = new HashSet<>();

	static boolean isStrContainOnlyAlphabetOrComma(String str) {
		if (str.matches("[a-zA-z,]+")) {
			return true;
		}
		throw new IllegalArgumentException(ErrorMessageText.ENGLISH_AND_COMMA_ONLY);
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
		throw new IllegalArgumentException(ErrorMessageText.NOT_ALLOWED_LENGTH_RANGE);
	}

	private boolean hasNoDuplication() {
		if (carNameSet.contains(carName)) {
			throw new IllegalArgumentException(ErrorMessageText.DUPLICATION_NOT_ALLOWED);
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
		throw new IllegalArgumentException(ErrorMessageText.INTEGER_ONLY_ALLOWED);
	}

	private boolean isGreaterThan1(String str) {
		int num = Integer.parseInt(str);
		if (1 <= num) {
			return true;
		}
		throw new IllegalArgumentException(ErrorMessageText.SHOULD_BIGGER_THAN_1);
	}
}

class ErrorMessageText {
	static final String START = "[ERROR]";
	static final String ENGLISH_AND_COMMA_ONLY = START + "자동차이름 입력 시 영문과 쉼표만 허용됩니다.";
	static final String DUPLICATION_NOT_ALLOWED = START + "자동차이름 입력 시 중복은 허용되지 않습니다.";
	static final String NOT_ALLOWED_LENGTH_RANGE = START + "자동차이름의 길이는 5이하만 허용됩니다.";
	static final String INTEGER_ONLY_ALLOWED = START + "반복 횟수는 자연수만 입력 가능합니다.";
	static final String SHOULD_BIGGER_THAN_1 = START + "반복횟수는 1보다 커야 합니다.";
}
