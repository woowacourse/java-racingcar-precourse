package racingcar;

import static constant.RacingCarGameMessage.*;
import static constant.RacingCarGameRule.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Console;

public class User {

	private List<String> names;
	private int numberOfTimes;

	public List<String> getNames() {
		return names;
	}

	public void askNamesUntilCorrect() {
		String input = inputNames();
		while (!setNames(input)) {
			input = inputNames();
		}
	}

	private String inputNames() {
		System.out.println(INPUT_MESSAGE_NAMES);
		String input = Console.readLine();
		return input;
	}

	private boolean setNames(String input) {
		List<String> inputList = Arrays.asList(input.split(DELIMITER, -1));
		if (checkNames(inputList)) {
			this.names = inputList;
			return true;
		}
		return false;
	}

	private boolean checkNames(List<String> inputList) {
		try {
			checkNamesLength(inputList);
			checkNamesDuplication(inputList);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

	private void checkNamesLength(List<String> inputList) {
		for (String name : inputList) {
			if (name.length() > MAX_NAME_LENGTH || name.length() < MIN_NAME_LENGTH) {
				throw new IllegalArgumentException(ERROR_MESSAGE_NAME_LENGTH);
			}
		}
	}

	private void checkNamesDuplication(List<String> inputList) {
		Set<String> namesSet = new HashSet<>();
		for (String name : inputList) {
			if (namesSet.contains(name)) {
				throw new IllegalArgumentException(ERROR_MESSAGE_NAME_DUPLICATION);
			}
			namesSet.add(name);
		}
	}

	public int getNumberOfTimes() {
		return numberOfTimes;
	}

	public void askNumberOfTimesUntilCorrect() {
		String input = inputNumberOfTimes();
		while (!setNumberOfTimes(input)) {
			input = inputNumberOfTimes();
		}
	}

	private String inputNumberOfTimes() {
		System.out.println(INPUT_MESSAGE_NUMBER_OF_TIMES);
		String input = Console.readLine();
		return input;
	}

	private boolean setNumberOfTimes(String input) {
		if (checkNumberOfTimes(input)) {
			this.numberOfTimes = Integer.valueOf(input);
			return true;
		}
		return false;
	}

	private boolean checkNumberOfTimes(String input) {
		try {
			checkInputIsNumber(input);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

	private void checkInputIsNumber(String input) {
		for (int i = 0; i < input.length(); i++) {
			if (!(input.charAt(i) >= '0' && input.charAt(i) <= '9')) {
				throw new IllegalArgumentException(ERROR_MESSAGE_INPUT_IS_NOT_NUBMER);
			}
		}
	}
}
