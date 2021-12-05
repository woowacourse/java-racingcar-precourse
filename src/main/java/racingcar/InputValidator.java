package racingcar;

public class InputValidator {
	private static final int CAR_MINIMUM_NUMBER = 2;
	private static final int CAR_NAME_MAX_LENGTH = 5;
	private static final String INVALID_CAR_NUMBER_MESSAGE = "자동차는 2대 이상이어야 합니다.";
	private static final String INVALID_CAR_NAME_MESSAGE = "자동차의 이름은 5글자 이하여야 합니다.";
	private static final String INVALID_ROUND_NUMBER_MESSAGE = "시도 횟수는 숫자여야 합니다.";

	public static void checkIsValidCarNames(String[] carNames) {
		if (carNames.length < CAR_MINIMUM_NUMBER) {
			throw new IllegalArgumentException(INVALID_CAR_NUMBER_MESSAGE);
		}
		for (String carName : carNames) {
			if (carName.length() > CAR_NAME_MAX_LENGTH) {
				throw new IllegalArgumentException(INVALID_CAR_NAME_MESSAGE);
			}
		}
	}

	public static void checkIsValidRoundNumber(String roundNumber) {
		for (int i = 0; i < roundNumber.length(); i++) {
			if (!Character.isDigit(roundNumber.charAt(i))) {
				throw new IllegalArgumentException(INVALID_ROUND_NUMBER_MESSAGE);
			}
		}
	}
}