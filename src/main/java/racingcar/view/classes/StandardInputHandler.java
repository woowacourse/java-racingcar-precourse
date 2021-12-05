package racingcar.view.classes;

import static camp.nextstep.edu.missionutils.Console.*;
import static racingcar.common.constants.ExceptionConstants.*;
import static racingcar.common.constants.NumberConstants.*;
import static racingcar.common.constants.PromptConstants.*;

import racingcar.exception.OverMaxLengthOfException;

public class StandardInputHandler {
	private String[] names;

	public void proceedInputNames() {
		names = makeListOfNames(inputNames());
	}

	public String inputNames() {
		printAskingNamesMessage();
		return readUserInputNames();
	}

	public String[] getNames() {
		return names;
	}

	private void printAskingNamesMessage() {
		System.out.println(ASKING_NAMES_MESSAGE);
	}

	private String readUserInputNames() {
		return readLine();
	}

	private boolean checkValidationInputNames(String[] userInput) {
		try {
			for (String element : userInput) {
				checkValidationInputName(element);
			}
		} catch (IllegalArgumentException exception) {
			return false;
			//proceedInputNames();
			//break;
		} finally {
			//proceedInputNames();
		}

		return true;
	}

	private void checkValidationInputName(String element) {
		if (element.length() > MAX_LENGTH_OF_NAME) {
			System.out.println(OVER_FIVE_WORDS_ERROR_MESSAGE);
			throw new OverMaxLengthOfException();
		}
	}

	private String[] makeListOfNames(String userInput) {
		String[] tmpListOfNames = splitByComma(userInput);
		if (!checkValidationInputNames(tmpListOfNames)) {
			return new String[] {"error"};
		}
		return tmpListOfNames;
	}

	private String[] splitByComma(String string) {
		return string.split(",");
	}
}
