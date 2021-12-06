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
			checkNamesNumber(input);
			checkNamesContainSpace(input);
			checkNamesContainTap(input);
			checkNamesLength(input);
			checkNamesDuplication(input);
		} catch (Exception e) {
			System.out.println(ERROR + e.getMessage());
			return false;
		}
		return true;
	}

	private void checkNamesNumber(String input) {
		try {
			List<String> test = Arrays.asList(input.split(DELIMITER, -1));
		} catch (Exception e) {
			throw new IllegalArgumentException(ERROR_MESSAGE_NAMES_NUMBER);
		}
	}

	private void checkNamesContainSpace(String input) {

		if (input.contains(SPACE)) {
			throw new IllegalArgumentException(ERROR_MESSAGE_NAME_CONTAINS_SPACE);
		}

	}

	private void checkNamesContainTap(String input) {

		if (input.contains(TAP)) {
			throw new IllegalArgumentException(ERROR_MESSAGE_NAME_CONTAINS_TAP);
		}

	}

	private void checkNamesLength(String input) {
		List<String> inputList = Arrays.asList(input.split(DELIMITER, -1));

		for (String name : inputList) {

			if (name.length() > MAX_NAME_LENGTH || name.length() < MIN_NAME_LENGTH) {
				throw new IllegalArgumentException(ERROR_MESSAGE_NAME_LENGTH);
			}

		}
	}

	private void checkNamesDuplication(String input) {
		List<String> inputList = Arrays.asList(input.split(DELIMITER, -1));
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
			checkInputIsPositiveNumberOrZero(input);
			checkInputExceedInteger(input);
			checkInputIsNotZero(input);
		} catch (Exception e) {
			System.out.println(ERROR + e.getMessage());
			return false;
		}
		return true;
	}

	private void checkInputIsPositiveNumberOrZero(String input) {

		for (int i = 0; i < input.length(); i++) {

			if (!(input.charAt(i) >= '0' && input.charAt(i) <= '9')) {
				throw new IllegalArgumentException(ERROR_MESSAGE_INPUT_IS_NOT_POSITIVE_NUBMER_OR_ZERO);
			}

		}
	}

	private void checkInputExceedInteger(String input) {
		try {
			int test = Integer.parseInt(input);
		} catch (Exception e) {
			throw new IllegalArgumentException(ERROR_MESSAGE_EXCEED_INTEGER);
		}
	}

	private void checkInputIsNotZero(String input) {

		if (Integer.parseInt(input) == 0) {
			throw new IllegalArgumentException(ERROR_MESSAGE_INPUT_IS_ZERO);
		}

	}

}
