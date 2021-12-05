package racingcar.util;

public class StringUtils {
	private StringUtils() {};

	public static String[] splitComma(String string, String separator) {
		return string.split(separator);
	}

	public static String trim(String string) {
		return string.trim();
	}
}
