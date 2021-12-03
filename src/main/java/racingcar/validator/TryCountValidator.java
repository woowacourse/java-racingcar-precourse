package racingcar.validator;

public class TryCountValidator {

	private static final String DIGIT_VALUE_ERROR_MESSAGE = "[ERROR] 시도 횟수는 단 하나의 올바른 숫자만 허용합니다.";
	private static final String EXCEPT_ZERO_ERROR_MESSAGE = "[ERROR] 시도 횟수는 자연수만 가능합니다.";

	private String errorMessage = null;

	public boolean validate(String tryCountString) {
		try {
			keepDigitValue(tryCountString);
			keepDigitExceptZero(tryCountString);

			return false;
		} catch (IllegalArgumentException illegalArgumentException) {
			System.out.println(errorMessage);

			return true;
		}
	}

	private void keepDigitValue(String tryCountString) throws IllegalArgumentException {
		for (int i = 0; i < tryCountString.length(); i++) {
			char c = tryCountString.charAt(i);

			if (!Character.isDigit(c)) {
				errorMessage = DIGIT_VALUE_ERROR_MESSAGE;

				throw new IllegalArgumentException();
			}
		}
	}

	private void keepDigitExceptZero(String tryCountString) throws IllegalArgumentException {
		int number = Integer.parseInt(tryCountString);
		if (number <= 0) {
			errorMessage = EXCEPT_ZERO_ERROR_MESSAGE;

			throw new IllegalArgumentException();
		}
	}
}
