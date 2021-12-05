package utils;

import java.lang.IllegalArgumentException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class MissionUtils {
	private static final String specialCharMessage = "[ERROR] 자동차의 이름에는 특수문자 혹은 공백이 들어갈 수 없습니다.\n";
	private static final String lengthMessage = "[ERROR] 자동차의 이름의 글자수는 5를 초과할 수 없습니다.\n";
	private static final String duplicationMessage = "[ERROR] 자동차의 이름은 중복을 허용하지 않습니다.\n";
	private static final String someIntMessage = "[ERROR] 전체 게임 횟수는 1자리 이상의 양수여야 합니다.\n";
	private static final String blankParsedInputMessage = "[ERROR] 자동차는 1대 이상이어야 합니다.\n";

	public static ArrayList<String> parseInput(String input, String delimiter) {
		ArrayList<String> parsedName = new ArrayList<>();
		parsedName.addAll(Arrays.asList(input.split(delimiter)));
		return parsedName;
	}

	public static void checkSpecialChar(ArrayList<String> input, String regexCondition) throws IllegalArgumentException {
		for (String inputToken : input) {
			if (!inputToken.matches(regexCondition)) {
				throw new IllegalArgumentException(specialCharMessage);
			}
		}
	}

	public static void checkLength(ArrayList<String> input, int size) throws IllegalArgumentException {
		for (String inputToken : input) {
			if (inputToken.length() > size) {
				throw new IllegalArgumentException(lengthMessage);
			}
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
		if (Integer.valueOf(inputToken) <= someInt || inputToken.isEmpty()) {
			throw new IllegalArgumentException(someIntMessage);
		}
	}

	public static void checkEmptyArray(ArrayList<String> parsedInput) throws IllegalArgumentException {
		if (parsedInput.isEmpty()) {
			throw new IllegalArgumentException(blankParsedInputMessage);
		}
	}
}
