package racingcar.model;

import java.util.regex.Pattern;

public class RoundCountValidation {
	private final String roundNumString;

	public RoundCountValidation(String roundNumString) {
		this.roundNumString = roundNumString;
	}

	public void validate() {
		isInt();
	}

	private void isInt() {
		String pattern = "^[1-9][0-9]*$"; //숫자만 됨
		if (Pattern.matches(pattern, roundNumString)) {
			return;
		}
		throw new IllegalArgumentException(Constants.ROUND_NUM_WRONG_ERROR);
	}
}
