package racingcar.validator;

public class TryNumberValidator {
	public static void IsInteger(String tryNumber) {
		try {
			Integer.parseInt(tryNumber);
		} catch (NumberFormatException exception) {
			throw new IllegalArgumentException("[ERROR] 시도 횟수는 숫자여야 한다.");
		}
	}

	public static void IsPositiveInteger(String tryNumber) {
		int tryNumberInt = Integer.parseInt(tryNumber);
		if (tryNumberInt <= 0) {
			throw new IllegalArgumentException("[ERROR] 시도 횟수는 양의 정수여야 한다.");
		}
	}
}
