package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

	public static final String DELIMETER = ",";

	public static String getInput() {
		return Console.readLine();
	}

	public static List<String> getNames() {
		try {
			String inputValue = InputView.getInput();
			checkNamesValidation(inputValue, DELIMETER);
			return Arrays.asList(inputValue.split(DELIMETER));
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			return InputView.getNames();
		}
	}

	private static void checkNamesValidation(String inputValue, String delimeter) {
		checkNullOrEmpty(inputValue);
		checkValidFirstValue(inputValue, delimeter);
		checkValidCountOfNames(inputValue, delimeter);
		checkDuplicatesOfNames(inputValue, delimeter);
		checkLengthEveryName(inputValue, delimeter);
	}

	private static void checkNullOrEmpty(String inputValue) {
		if (inputValue == null || inputValue.trim().isEmpty()) {
			throw new IllegalArgumentException("빈칸 입력은 허용하지 않는다.");
		}
	}

	private static void checkValidFirstValue(String inputValue, String delimeter) {
		if (inputValue.charAt(0) == delimeter.charAt(0)) {
			throw new IllegalArgumentException("정상적인 이름을 입력하세요.");
		}
	}

	private static void checkValidCountOfNames(String inputValue, String delimeter) {
		if (inputValue.split(delimeter).length < 2) {
			throw new IllegalArgumentException("최소 2개 이상 입력하세요.");
		}
	}

	private static void checkDuplicatesOfNames(String inputValue, String delimeter) {
		List<String> splitedInputValue = Arrays.stream(inputValue.split(delimeter))
			.map(String::trim)  // split + 개별 trim()적용 -> list로 모으기
			.collect(Collectors.toList());
		if (splitedInputValue.stream().distinct().count() != splitedInputValue.size()) {
			throw new IllegalArgumentException("중복값을 입력할 수 없습니다.");
		}
	}

	private static void checkLengthEveryName(String inputValue, String delimeter) {
		List<String> splitedInputValue = Arrays.stream(inputValue.split(delimeter))
			.map(String::trim)
			.collect(Collectors.toList());
		if (!isValidName(splitedInputValue)) { // 딜리미터쪼갠후    개별단어, [[입력갯수(길이) 최소 ~ 최대값]] 입력
			throw new IllegalArgumentException("각 Name은(는) " + 1 + " ~ " + 5 + "자 사이로 입력해주세요.");
		}
	}

	private static boolean isValidName(List<String> splitedInputValue) {
		return splitedInputValue.stream()
			.allMatch(name -> 1 <= name.length()
				&& name.length() <= 5);
	}

	public static int getCount() {
		try {
			String inputValue = InputView.getInput();
			checkCountValidation(inputValue);

			return Integer.parseInt(inputValue);
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			return getCount();
		}
	}

	private static void checkCountValidation(String inputValue) {
		checkNullOrEmpty(inputValue);
		checkValidFormatOfCount(inputValue);
		checkValidRangeCount(inputValue);

	}

	private static void checkValidFormatOfCount(String inputValue) {
		if (!(inputValue.chars().allMatch(Character::isDigit))) {
			throw new IllegalArgumentException("시도 횟수는 숫자여야 한다.");
		}
	}

	private static void checkValidRangeCount(String inputValue) {
		int number = Integer.parseInt(inputValue);
		if (1 > number) {
			throw new IllegalArgumentException("정상 범위(" + 1 + "이상)가 아닙니다");
		}
	}
}
