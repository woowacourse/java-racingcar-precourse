package utils;

import java.lang.IllegalArgumentException;

public class Utils {
	private static final String specialCharMessage = "[ERROR] 자동차의 이름에는 특수문자 혹은 공백이 들어갈 수 없습니다.\n";

	public static void checkSpecialChar(String inputToken, char start, char end) throws IllegalArgumentException {
		for (int index = 0; index < inputToken.length(); index++) {
			if (!(start <= inputToken.charAt(index) && inputToken.charAt(index) <= end)) {
				throw new IllegalArgumentException(specialCharMessage);
			}
		}
	}
}
