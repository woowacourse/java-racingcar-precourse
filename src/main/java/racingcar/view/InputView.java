package racingcar.view;

import static racingcar.constant.GameConstants.UserInputDelimiter.*;
import static racingcar.constant.GameConstants.UserInputHint.*;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.UserInputValidator;

public class InputView {
	public static List<String> inputNameList() throws IllegalArgumentException {
		System.out.println(NAME_INPUT_HINT.getString());

		List<String> userInputNameList = Arrays.asList(
			Console.readLine().split(USER_NAME_INPUT_DELIMITER.getString(), -1));
		UserInputValidator.validateUserInputNameListLength(userInputNameList);
		userInputNameList.forEach(UserInputValidator::validateUserInputNameLength);
		return userInputNameList;
	}

	public static int inputIterationNumber() throws IllegalArgumentException {
		System.out.println(ITERATION_NUMBER_INPUT_HINT.getString());

		String userInputIterationNumber = Console.readLine();
		UserInputValidator.validateUserInputIterationNumberInteger(userInputIterationNumber);
		UserInputValidator.validateUserInputIterationNumberRange(userInputIterationNumber);
		return Integer.parseInt(userInputIterationNumber);
	}
}
