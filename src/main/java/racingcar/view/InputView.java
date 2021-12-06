package racingcar.view;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import racingcar.utils.Util;

public class InputView {

	public static final String DELIMETER = ",";

	public static String getInput() {
		return Console.readLine();
	}

	public static List<String> getNames() {
		try {
			String inputValue = InputView.getInput();
			Util.checkNamesValidation(inputValue, DELIMETER);
			return Arrays.asList(inputValue.split(DELIMETER));
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			return InputView.getNames();
		}
	}

	public static int getCount() {
		try {
			String inputValue = InputView.getInput();
			Util.checkCountValidation(inputValue);
			return Integer.parseInt(inputValue);
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			return getCount();
		}
	}

}
