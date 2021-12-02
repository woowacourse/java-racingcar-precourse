package racingcar.validator;

public class TryCountValidator {

	private static final String DIGIT_VALUE_ERROR_MESSAGE = "[ERROR] 시도 횟수는 단 하나의 올바른 숫자만 허용합니다.";

	private String errorMessage = null;

	public boolean validate(String tryCountString) {
		try {
			keepDigitValue(tryCountString);

			// 공백 라인 출력
			System.out.println();

			return false;
		} catch (IllegalArgumentException illegalArgumentException) {
			System.out.println(DIGIT_VALUE_ERROR_MESSAGE);

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
}
