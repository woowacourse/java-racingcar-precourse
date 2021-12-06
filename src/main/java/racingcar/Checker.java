package racingcar;

import static constant.RacingCarGameMessage.*;
import static constant.RacingCarGameRule.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Checker {

	public boolean checkNames(String input) {
		try {
			List<String> inputList = Arrays.asList(input.split(DELIMITER, -1));
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

	public boolean checkNumberOfTimes(String input) {
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
