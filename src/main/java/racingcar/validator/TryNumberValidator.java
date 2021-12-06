package racingcar.validator;

public class TryNumberValidator {
	public static void IsInteger(String input) {
		try {
			Integer.parseInt(input.trim());
		} catch (NumberFormatException exception) {
			System.out.println("[ERROR] 시도 횟수는 숫자여야 한다.");
			throw new IllegalArgumentException();
		}
	}

	public static void IsPositiveInteger(String input) {
		int number = Integer.parseInt(input.trim());
		if (number <= 0) {
			System.out.println("[ERROR] 시도 횟수는 양의 정수여야 한다.");
			throw new IllegalArgumentException();
		}
	}
}
