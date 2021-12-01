package racingcar;

public class ValidationUtils {

	private static final int MAX_LENGTH_CAR_NAME = 5;

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

	public static boolean validCarName(String testCarName) {
		return testCarName.length() <= MAX_LENGTH_CAR_NAME;
	}
}
