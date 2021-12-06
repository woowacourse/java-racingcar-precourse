package racingcar.view;

import java.util.ArrayList;
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
			List<String> tempCarNameList = Arrays.asList(Console.readLine().split(","));
			List<String> carNameList = removeBlankInCarName(tempCarNameList);
			isValidCarNameList = Validator.isValidCarName(carNameList);
			if (isValidCarNameList) {
				return carNameList;
			}
		}
	}

	public static List<String> removeBlankInCarName(List<String> carNameList) {
		ArrayList<String> blankRemovedCarNameList = new ArrayList<>();
		for (String name : carNameList) {
			blankRemovedCarNameList.add(name.trim());
		}
		return blankRemovedCarNameList;
	}

	public static void printAttemptInputMessage() {
		System.out.println(Message.INPUT_ATTEMPT_NUMBER.getMessage());
	}

	public static int inputAttemptNumber() {
		boolean isValidAttemptNumber;
		while (true) {
			String tempInput = Console.readLine();
			isValidAttemptNumber = Validator.isValidAttemptNumber(tempInput);
			if (isValidAttemptNumber) {
				return Integer.parseInt(tempInput);
			}
		}
	}
}
