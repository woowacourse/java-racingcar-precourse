package racingcar;

public class ValidationUtils {

	public static boolean validNo(int No) {
		return No >= NumberRange.MIN_NO.getValue() && No <= NumberRange.MAX_NO.getValue();
	}

	public static boolean validNumber(String input) {
		try {
			Integer.parseInt(input);
		} catch (IllegalArgumentException e) {
			System.out.println("[ERROR] 시도 횟수는 숫자여야 한다.");
			return false;
		}
		return true;
	}
}
