package racingcar.view;

import java.util.Arrays;
import java.util.HashSet;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	private static final int MAX_CAR_NAME_LENGTH = 5;
	private static final int MIN_SINGLE_NUMBER = 0;
	private static final int MAX_SINGLE_NUMBER = 9;
	private static final String ERROR_MESSAGE = "[ERROR] ";
	private static final String INPUT_CAR_NAMES_TITLE_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String INPUT_CAR_MOVING_NUMBER_TITLE_MESSAGE = "시도할 회수는 몇회인가요?";
	private static final String DELIMITER_CAR_NAME = ",";

	public static String[] inputCarNames() {
		try {
			System.out.println(INPUT_CAR_NAMES_TITLE_MESSAGE);
			String input = Console.readLine();
			validateCarNames(input);
			return input.split(DELIMITER_CAR_NAME);
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			return inputCarNames();
		}
	}

	public static void validateCarNames(String input) {
		validateIsEmpty(input);
		String[] carNames = input.split(DELIMITER_CAR_NAME);
		validateLengthOfCarName(carNames);
		validateDuplicateCarNames(carNames);
	}

	private static void validateDuplicateCarNames(String[] carNames) {
		HashSet<String> tempSet = new HashSet<>(Arrays.asList(carNames));
		if (tempSet.size() != carNames.length) {
			throw new IllegalArgumentException(ERROR_MESSAGE + "중복된 자동차 이름이 있습니다.");
		}
	}

	private static void validateIsEmpty(String input) {
		if (input.isEmpty()) {
			throw new IllegalArgumentException("입력 글자는 최소 1글자 이상입니다.");
		}
	}

	private static void validateLengthOfCarName(String[] names) {
		for (String name : names) {
			if (name.length() > MAX_CAR_NAME_LENGTH) {
				throw new IllegalArgumentException(ERROR_MESSAGE + "입력한 이름이 5글자를 초과합니다.");
			}
		}
	}

	public static int inputNumberOfCarMoving() {
		try {
			System.out.println(INPUT_CAR_MOVING_NUMBER_TITLE_MESSAGE);
			String numberOfCarMoving = Console.readLine();
			validateIsIntegerNumberOfCarMoving(numberOfCarMoving);
			return Integer.parseInt(numberOfCarMoving);
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
			return inputNumberOfCarMoving();
		}
	}

	private static void validateIsIntegerNumberOfCarMoving(String numberOfCarMoving) {
		for (int i = 0; i < numberOfCarMoving.length(); i++) {
			int number = Character.getNumericValue(numberOfCarMoving.charAt(i));
			if (number < MIN_SINGLE_NUMBER || number > MAX_SINGLE_NUMBER) {
				throw new IllegalArgumentException(ERROR_MESSAGE + "시도 횟수는 숫자여야 한다.");
			}
		}
	}
}
