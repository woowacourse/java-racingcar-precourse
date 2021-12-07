package racingcar.model;

import java.util.regex.Pattern;

import racingcar.Constants;

public class RoundCountValidator {
	public final String ROUND_NUM_STRING;

	public RoundCountValidator(String roundNumString) {
		this.ROUND_NUM_STRING = roundNumString;
		validate();
	}

	public void validate() {
		isInt();
	}

	private void isInt() {
		// String 형식 확인: 앞-0이 아닌 숫자, 이후-숫자
		if (!Pattern.matches("^[1-9][0-9]*$", ROUND_NUM_STRING)) {
			throw new IllegalArgumentException(Constants.ROUND_NUM_WRONG_ERROR);
		}
	}
}
