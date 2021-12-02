package racingcar.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser {
	private Validator validator = new Validator();

	public List<String> parseCarNames(String input) throws IllegalArgumentException {
		ArrayList<String> carNames = new ArrayList<>(Arrays.asList(input.split(",")));
		validator.checkCarNamesInput(carNames);
		return carNames;
	}

	public int parseNumberOfTrial(String input) {
		return Integer.parseInt(input);
	}
}
