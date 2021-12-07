package racingcar.controller;

public class InputController {
	public static void validateContainDelimiter(String input) throws IllegalArgumentException {
		if (!input.contains(",")) {
			throw new IllegalArgumentException();
		}
	}
}
