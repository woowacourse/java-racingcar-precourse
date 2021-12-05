package racingcar.view;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import racingcar.utils.Message;
import racingcar.utils.Validator;

public class InputView {
	public static void printCarNameInputMessage() {
		System.out.println(Message.INPUT_CAR_NAME.getMessage());
	}

	public static List<String> inputCarName() {
		boolean isValidCarNameList;
		while (true) {
			List<String> carNameList = Arrays.asList(Console.readLine().split(","));
			isValidCarNameList = Validator.checkValid(carNameList);
			if (isValidCarNameList) {
				return carNameList;
			}
		}
	}

	public static void printAttemptInputMessage() {
		System.out.println(Message.INPUT_ATTEMPT_NUMBER.getMessage());
	}

	public static int inputAttemptNumber() {
		boolean isValidAttemptNumber;
		while (true) {
			String tempInput = Console.readLine();
			isValidAttemptNumber = Validator.checkAttemptNumberValid(tempInput);
			if (isValidAttemptNumber) {
				return Integer.parseInt(tempInput);
			}
		}
	}
}
