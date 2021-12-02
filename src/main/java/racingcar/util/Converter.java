package racingcar.util;

public class Converter {
	public static String[] toStringArray(String str) {
		return str.split(",");
	}

	public static int toInt(String input) {
		int result = 0;
		try {
			result = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("[ERROR] 시도 횟수는 숫자여야 한다.");
		}

		return result;
	}
}
