package racingcar.utils;

import java.util.Arrays;
import java.util.List;

public class StringUtils {

	private static final int ACCEPT_ZERO_LENGTH = -1;

	public static boolean isBlank(String str) {
		if (str == null) {
			return true;
		}
		if (str.isEmpty()) {
			return true;
		}
		return false;
	}

	public static String repeat(String str, int count) {
		StringBuilder sb = new StringBuilder();
		while (count-- > 0) {
			sb.append(str);
		}
		return sb.toString();
	}

	public static List<String> toList(String str, String delimiter) {
		return Arrays.asList(str.split(delimiter, ACCEPT_ZERO_LENGTH));
	}
}
