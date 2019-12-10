package domain.utils;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public final class InputUtils {
	private static final String[] SEPARATOR = {",", "쉼표"};
	private static final String PROMPT_NAMES = String.format(
		"경주할 자동차 이름을 입력하세요.(이름은 %s(%s) 기준으로 구분)", SEPARATOR[1], SEPARATOR[0]);
	private static final int NAME_MAX_LEN = 5;
	private static final int NAME_MIN_LEN = 1;
	private static final String PROMPT_ROUNDS = "시도할 회수는 몇회인가요?";
	private static final String ERROR_MESSAGE = "유효하지 않은 입력입니다.";

	private static Scanner scanner = new Scanner(System.in);

	private InputUtils() {}

	public static Integer getRounds() {
		Integer inputValue;
		while (true) {
			System.out.println(PROMPT_ROUNDS);
			if (scanner.hasNextInt() && (inputValue = scanner.nextInt()) > 0) {
				break;
			}
			System.out.println(ERROR_MESSAGE);
			inputFlush();
		}
		inputFlush();
		return inputValue;
	}

	public static List<String> getNameList() {
		String inputValue;
		List<String> nameList;
		while (true) {
			System.out.println(PROMPT_NAMES);
			inputValue = scanner.nextLine();
			nameList = Arrays.asList(inputValue.split(SEPARATOR[0]));
			if (isValidNameList(nameList)) {
				break;
			}
			System.out.println(ERROR_MESSAGE);
		}
		return nameList;
	}

	private static boolean isValidName(String name) {
		return name.length() <= NAME_MAX_LEN && name.length() >= NAME_MIN_LEN;
	}

	private static boolean isValidNameList(List<String> nameList) {
		return nameList.stream()
			.map(name -> isValidName(name))
			.reduce(((validity1, validity2) -> validity1 & validity2))
			.get();
	}

	private static void inputFlush() {
		scanner.nextLine();
	}

	public static void inputClose() {
		scanner.close();
	}
}
