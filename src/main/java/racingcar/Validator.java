package racingcar;

public class Validator {

	private static final int CAR_NAME_LENGTH_LIMIT = 5;
	private static final String CAR_NAME_REGEX = "[A-Za-z]+";

	public static void isValidCarNameList(String[] nameList) throws IllegalArgumentException {
		if (nameList.length == 0) {
			throw new IllegalArgumentException("자동차 이름이 존재하지 않습니다.");
		}

		for (String name : nameList) {
			if (name.length() == 0) {
				throw new IllegalArgumentException("자동차 이름이 존재하지 않습니다.");
			}

			if (!name.matches(CAR_NAME_REGEX)) {
				throw new IllegalArgumentException("자동차 이름은 영어 대소문자만 허용됩니다.");
			}

			if (name.length() > CAR_NAME_LENGTH_LIMIT) {
				throw new IllegalArgumentException("자동차 이름의 길이는 5자 이하만 허용됩니다.");
			}
		}
	}

}
