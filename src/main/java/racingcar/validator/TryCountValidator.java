package racingcar.validator;

public class TryCountValidator {

	private static final String TRY_COUNT_ERROR_MESSAGE = "[ERROR] 시도 횟수의 값이 적절하지 않습니다.";

	public boolean validate(String tryCountString) {
		try {
			keepDigitValue(tryCountString);

			// 공백 라인 출력
			System.out.println();

			return false;
		} catch (IllegalArgumentException illegalArgumentException) {
			System.out.println(TRY_COUNT_ERROR_MESSAGE);

			return true;
		}
	}

	private void keepDigitValue(String tryCountString) throws IllegalArgumentException {
		for (int i = 0; i < tryCountString.length(); i++) {
			char c = tryCountString.charAt(i);

			if (!Character.isDigit(c)) {
				throw new IllegalArgumentException();
			}
		}
	}
}
