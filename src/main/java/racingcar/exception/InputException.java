package racingcar.exception;

public class InputException {
	private static final String CAR_LAST_NAME_IS_COMMA = "[ERROR] 마지막 자동차 이름을 입력하지 않았습니다.";

	public static String isValidCarNames(String inputCarNames) {

		haveLastNameComma(inputCarNames);
		return inputCarNames;
	}

	private static void haveLastNameComma(String carNames) {
		if (',' == carNames.charAt(carNames.length() - 1)) {
			throw new IllegalArgumentException(CAR_LAST_NAME_IS_COMMA);
		}
	}

}
