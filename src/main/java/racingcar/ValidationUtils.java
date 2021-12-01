package racingcar;

public class ValidationUtils {

	private static final int MIN_NO = 0;
	private static final int MAX_NO = 9;

	public static boolean validNo(int No) {
		return No >= MIN_NO && No <= MAX_NO;
	}

	public static boolean isNumber(String input) {
		try {
			Integer.parseInt(input);
		} catch (IllegalArgumentException e) {
			System.out.println("[ERROR] 시도 횟수는 숫자여야 한다.");
			return false;
		}
		return true;
	}
}
