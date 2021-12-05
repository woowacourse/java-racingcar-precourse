package racingcar;

public class Validation {
	public static void validateLength(String input, int len) {
		if (input.length() > len) {
			System.out.println("[ERROR] 자동차 이름은 5자 이하만 가능하다.");
			throw new IllegalArgumentException();
		}
	}

	public static void validateEmpty(String input) {
		if (input.equals("")){
			System.out.println("[ERROR] 자동차 이름은 공백일 수 없다.");
			throw new IllegalArgumentException();
		}
	}

	public static void validateIsInteger(String input) {
		try {
			Integer.parseInt(input.trim());
		} catch (NumberFormatException exception){
			System.out.println("[ERROR] 시도 횟수는 숫자여야 한다.");
			throw new IllegalArgumentException();
		}
	}

	public static void validateIsPositiveInteger(String input) {
		int number = Integer.parseInt(input.trim());
		if (number <= 0) {
			System.out.println("[ERROR] 시도 횟수는 양의 정수여야 한다.");
			throw new IllegalArgumentException();
		}
	}
}
