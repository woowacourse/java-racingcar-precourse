package racingcar;

import java.util.regex.Pattern;

import camp.nextstep.edu.missionutils.Console;

public class InputValidator {
	public String[] carNames() {
		String userInput = Console.readLine();
		String[] names = userInput.split(",");
		String pattern = "^(\\w){1,5}$";
		for (String name : names) {
			boolean regex = Pattern.matches(pattern, name);
			if (!regex) {
				throw new IllegalArgumentException(Constants.ERROR + Constants.WRONG_CAR_NAMES);
			}
		}
		return names;
	}

	public int playTimes() {
		String userInput = Console.readLine();
		String pattern = "^[1-9]+[0-9]*$";
		boolean regex = Pattern.matches(pattern, userInput);
		if (!regex) {
			throw new IllegalArgumentException(Constants.ERROR + Constants.WRONG_PLAY_TIMES);
		}
		return Integer.parseInt(userInput);
	}
}
