package racingcar;

public class Validator {

	private static final int CAR_NAME_LENGTH_LIMIT = 5;
	private static final String CAR_NAME_REGEX = "[A-Za-z]+";

	public static boolean isValidCarNameList(String[] nameList) throws IllegalArgumentException {
		checkNameListLength(nameList.length);

		for (String name : nameList) {
			checkNameLength(name.length());
			checkNameCharacter(name);
		}

		return true;
	}

	private static void checkNameListLength(int length) {
		if (length == 0) {
			throw new IllegalArgumentException("자동차 이름이 존재하지 않습니다.");
		}
	}

	private static void checkNameLength(int length) {
		if (length == 0) {
			throw new IllegalArgumentException("자동차 이름이 존재하지 않습니다.");
		}

		if (length > CAR_NAME_LENGTH_LIMIT) {
			throw new IllegalArgumentException("자동차 이름의 길이는 5자 이하만 허용됩니다.");
		}
	}

	private static void checkNameCharacter(String name) {
		if (!name.matches(CAR_NAME_REGEX)) {
			throw new IllegalArgumentException("자동차 이름은 영어 대소문자만 허용됩니다.");
		}
	}

	public static boolean isValidNumber(String number) throws IllegalArgumentException {
		for (int i = 0; i < number.length(); i++) {
			checkCharacterIsDigit(number.charAt(i));
		}

		return true;
	}

	private static void checkCharacterIsDigit(char character) {
		if (!Character.isDigit(character)) {
			throw new IllegalArgumentException("시도 횟수는 숫자만 허용됩니다.");
		}
	}

}
