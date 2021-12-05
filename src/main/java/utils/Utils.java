package utils;

import java.lang.IllegalArgumentException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Utils {
	private static final String specialCharMessage = "[ERROR] 자동차의 이름에는 특수문자 혹은 공백이 들어갈 수 없습니다.\n";
	private static final String lengthMessage = "[ERROR] 자동차의 이름의 글자수는 5를 초과할 수 없습니다.\n";
	private static final String duplicationMessage = "[ERROR] 자동차의 이름은 중복을 허용하지 않습니다.\n";
	private static final String someIntMessage = "[ERROR] 전체 게임 횟수는 양수여야 합니다.\n";

	public static ArrayList<String> parseInput(String input, String delimiter) {
		ArrayList<String> parsedName = new ArrayList<>();
		parsedName.addAll(Arrays.asList(input.split(delimiter)));
		return parsedName;
	}

	public static void checkSpecialChar(String inputToken, char start, char end) throws IllegalArgumentException {
		for (int index = 0; index < inputToken.length(); index++) {
			if (!(start <= inputToken.charAt(index) && inputToken.charAt(index) <= end)) {
				throw new IllegalArgumentException(specialCharMessage);
			}
		}
	}

	public static void checkLength(String inputToken, int size) throws IllegalArgumentException {
		if (inputToken.length() > size) {
			throw new IllegalArgumentException(lengthMessage);
		}
	}

	public static void checkDuplication(ArrayList<String> input) throws IllegalArgumentException {
		HashSet<String> nameSet = new HashSet<>();
		for (String inputToken : input) {
			if (nameSet.contains(inputToken)) {
				throw new IllegalArgumentException(duplicationMessage);
			}
			nameSet.add(inputToken);
		}
	}

	public static void checkOverSomeInt(String inputToken, int someInt) throws IllegalArgumentException {
		if (Integer.valueOf(inputToken) <= someInt) {
			throw new IllegalArgumentException(someIntMessage);
		}
	}
}
