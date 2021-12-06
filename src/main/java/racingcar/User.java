package racingcar;

import static constant.RacingCarGameMessage.*;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class User {

	private List<String> names;
	private int numberOfTimes;

	public String inputNames() {
		System.out.println(INPUT_MESSAGE_NAMES);
		String input = Console.readLine();
		return input;
	}

	public List<String> getNames() {
		return names;
	}

	public void setNames(String input) {
		names = Arrays.asList(input.split(DELIMITER, -1));
	}

	public String inputNumberOfTimes() {
		System.out.println(INPUT_MESSAGE_NUMBER_OF_TIMES);
		String input = Console.readLine();
		return input;
	}

	public int getNumberOfTimes() {
		return numberOfTimes;
	}

	public void setNumberOfTimes(String input) {
		numberOfTimes = Integer.valueOf(input);
	}
}
