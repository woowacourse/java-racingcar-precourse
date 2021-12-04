package racingcar.input;

import camp.nextstep.edu.missionutils.Console;
import racingcar.exception.ErrorMessage;

public class Trial {

	private static final String TRIAL_INPUT_ERROR_MESSAGE = "1 이상의 정수를 입력하세요.";

	public static int input() {
		while (true) {
			try {
				String stringInput = Console.readLine();
				return getValidInput(stringInput);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
				ErrorMessage.print(e.getMessage());
			}
		}
	}

	private static int getValidInput(String inputString) {
		int integerInput = stringToInteger(inputString);
		validateUpperThanOne(integerInput);
		return integerInput;
	}

	private static void validateUpperThanOne(int trial) {
		if (trial < 1) {
			throw new IllegalArgumentException(TRIAL_INPUT_ERROR_MESSAGE);
		}
	}

	private static int stringToInteger(String inputString) {
		try {
			return Integer.parseInt(inputString);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(TRIAL_INPUT_ERROR_MESSAGE);
		}
	}
}
