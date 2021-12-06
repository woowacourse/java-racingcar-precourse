package racingcar.validator;

public class CarNameValidator {
	public static void checkLength(String input, int len) {
		if (input.length() > len) {
			System.out.println("[ERROR] 자동차 이름은 5자 이하만 가능하다.");
			throw new IllegalArgumentException();
		}
	}

	public static void IsEmpty(String input) {
		if (input.equals("")) {
			System.out.println("[ERROR] 자동차 이름은 공백일 수 없다.");
			throw new IllegalArgumentException();
		}
	}
}
