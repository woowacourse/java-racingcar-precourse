package racingcar.view.classes;

import static camp.nextstep.edu.missionutils.Console.*;
import static racingcar.common.constants.ExceptionConstants.*;
import static racingcar.common.constants.NumberConstants.*;
import static racingcar.common.constants.PromptConstants.*;

import racingcar.exception.NegativeNumberException;
import racingcar.exception.OverMaxLengthException;

public class StandardInputHandler {
	private String[] names;
	private int counts;

	public void proceedInputNames() {
		names = makeListOfNames(inputNames());
	}

	public void proceedInputCounts() {
		counts = inputCounts();
	}

	public int getCounts() {
		return counts;
	}

	private String inputNames() {
		printAskingNamesMessage();
		return readUserInputNames();
	}

	private int inputCounts() {
		int count = 0;
		printAskingCountsMessage();
		count = readUserInputCounts();
		checkValidationInputCounts(count);
		return count;
	}


	private int readUserInputCounts() {
		int result = 0;
		result = getValidateCount(result);
		return result;
	}

	private int getValidateCount(int result) {
		try {
			result = Integer.parseInt(readLine());
			if (result < 0) {
				System.out.println(NEGATIVE_NUMBER_COUNT_ERROR_MESSAGE);
			}
		} catch (NumberFormatException exception) {
			System.out.println(NOT_NUMBER_COUNT_ERROR_MESSAGE);
		}
		return result;
	}

	private void printAskingCountsMessage() {
		System.out.println(ASKING_COUNT_MESSAGE);
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
		}

		return true;
	}

	private boolean checkValidationInputCounts(int counts) {
		try {
			if (counts < 0) {
				throw new NegativeNumberException();
			}
		} catch (IllegalArgumentException exception) {
			return false;
		}
		return true;
	}

	private void checkValidationInputName(String element) {
		if (element.length() > MAX_LENGTH_OF_NAME) {
			System.out.println(OVER_FIVE_WORDS_ERROR_MESSAGE);
			throw new OverMaxLengthException();
		}
	}

	private String[] makeListOfNames(String userInput) {
		String[] tmpListOfNames = splitByComma(userInput);
		if (!checkValidationInputNames(tmpListOfNames)) {
			return new String[] {""};
		}
		return tmpListOfNames;
	}

	private String[] splitByComma(String string) {
		return string.split(",");
	}
}
