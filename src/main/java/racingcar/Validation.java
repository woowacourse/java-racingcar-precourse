package racingcar;

public class Validation {
	public static void validateLength(String str, int len) {
		if (str.length() > len) {
			System.out.println("[Error] 자동차 이름은 5자 이하만 가능하다.");
			throw new IllegalArgumentException();
		}
	}
}
