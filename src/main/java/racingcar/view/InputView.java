package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	private static final int MAX_CAR_NAME_LENGTH = 5;
	private static final String ERROR_MESSAGE = "[ERROR] ";
	private static final String INPUT_CAR_NAMES_TITLE_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String INPUT_CAR_MOVING_NUMBER_TITLE_MESSAGE= "시도할 회수는 몇회인가요?";

	public static String[] inputCarNames() {
		System.out.println(INPUT_CAR_NAMES_TITLE_MESSAGE);
		String[] names = Console.readLine().split(",");
		try {
			validateLengthOfCarName(names);
			return names;
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
			return inputCarNames();
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
			if (number < 0 || number > 9) {
				throw new IllegalArgumentException(ERROR_MESSAGE + "시도 횟수는 숫자여야 한다.");
			}
		}
	}
}
