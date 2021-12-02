package racingcar;

import static racingcar.MessagePrinter.*;
import static racingcar.Validator.*;

import camp.nextstep.edu.missionutils.Console;

public class InputReader {

	public static String[] returnCarNameList() {
		String[] nameList = new String[0];

		boolean isValid = false;
		while (!isValid) {
			String input = Console.readLine();
			nameList = input.split(",", -1);

			try {
				isValid = isValidCarNameList(nameList);
			} catch (IllegalArgumentException exception) {
				printError(exception);
			}
		}

		return nameList;
	}

	public static int returnNumberOfRepetitions() {
		String input = "";

		boolean isValid = false;
		while (!isValid) {
			input = Console.readLine();
			try {
				isValid = isValidNumber(input);
			} catch (IllegalArgumentException exception) {
				printError(exception);
			}
		}

		return Integer.parseInt(input);
	}

}
