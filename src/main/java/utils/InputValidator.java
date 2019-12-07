package utils;

import java.util.ArrayList;

public class InputValidator {
	private static final int MAXIMUM_INPUT_LENGTH = 5;
	private static final int MINIMUM_INPUT_NUMBER = 1;

	public static boolean isDuplicated(String[] inputs) {
		ArrayList<String> names = new ArrayList<>();

		for(String inputName : inputs) {
			if(names.contains(inputName)) {
				return true;
			}
			names.add(inputName);
		}
		return false;
	}

	public static boolean isEmptyLine(String[] inputs) {
		for(String inputName : inputs) {
			if(inputName.isEmpty()) {
				return true;
			}
		}
		return false;
	}

	public static boolean isOutOfRange(String[] inputs) {
		for(String inputName : inputs) {
			if(inputName.length() > MAXIMUM_INPUT_LENGTH) {
				return true;
			}
		}
		return false;
	}

	public static boolean isValidNumber(int inputNumber) {
		return inputNumber >= MINIMUM_INPUT_NUMBER;
	}
}
