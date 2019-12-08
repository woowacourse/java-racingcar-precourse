package domain.utils;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputUtils {
	private static final String[] SEPARATOR = {",", "쉼표"};
	private static final String PROMPT_NAMES = String.format(
		"경주할 자동차 이름을 입력하세요.(이름은 %s(%s) 기준으로 구분)", SEPARATOR[1], SEPARATOR[0]);
	private static final int NAMES_MAX_LEN = 5;
	private static final String PROMPT_TRIES = "시도할 회수는 몇회인가요?";
	private static final String ERROR_MESSAGE = "유효하지 않은 입력입니다.";

	static Scanner scanner = new Scanner(System.in);

	public static Integer inputTries() {
		Integer inputValue;
		while (true) {
			System.out.println(PROMPT_TRIES);
			if (scanner.hasNextInt() && (inputValue = scanner.nextInt()) > 0) {
				break;
			}
			System.out.println(ERROR_MESSAGE);
			inputFlush();
		}
		inputFlush();
		return inputValue;
	}

	public static List<String> inputNames() {
		String inputValue;
		List<String> namesList;
		while (true) {
			System.out.println(PROMPT_NAMES);
			inputValue = scanner.nextLine();
			namesList = Arrays.asList(inputValue.split(SEPARATOR[0]));
			if (isValidName(namesList)) {
				break;
			}
			System.out.println(ERROR_MESSAGE);
		}
		return namesList;
	}

	private static boolean isValidName(List<String> namesList) {
		if (namesList == null) {
			return false;
		}
		for (String s : namesList) {
			if (s.length() > NAMES_MAX_LEN) {
				return false;
			}
		}
		return true;
	}

	private static void inputFlush() {
		scanner.nextLine();
	}

	public static void inputClose() {
		scanner.close();
	}
}
