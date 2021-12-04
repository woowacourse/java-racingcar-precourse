package racingcar.model;

import java.util.regex.Pattern;

public class RoundCountValidation {
	private final String ROUND_NUM_STRING;

	public RoundCountValidation(String roundNumString) {
		this.ROUND_NUM_STRING = roundNumString;
	}

	public void validate() {
		isInt();
	}

	private void isInt() {
		String pattern = "^[1-9][0-9]*$"; //숫자만 됨
		if (Pattern.matches(pattern, ROUND_NUM_STRING)) {
			return;
		}
		throw new IllegalArgumentException(Constants.ROUND_NUM_WRONG_ERROR);
	}
}
