package racingcar.input;

import static racingcar.input.constants.InputConstants.*;

import camp.nextstep.edu.missionutils.Console;
import racingcar.exception.ErrorMessage;

public class Trial {

	public static int input() {
		while (true) {
			try {
				String stringInput = Console.readLine();
				return getValidInput(stringInput);
			} catch (IllegalArgumentException e) {
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
