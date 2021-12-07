package racingcar.model;

import racingcar.Constants;

public class RoundNumValidator {
	public final String ROUND_NUM_STRING;

	public RoundNumValidator(String roundNumString) {
		this.ROUND_NUM_STRING = roundNumString;
		validate();
	}

	public void validate() {
		isInt();
	}

	private void isInt() {
		// String 형식 확인: 앞-0이 아닌 숫자, 이후-숫자
		if (!Constants.roundNumPattern.matcher(ROUND_NUM_STRING).matches()) {
			throw new IllegalArgumentException(Constants.ROUND_NUM_WRONG_ERROR);
		}
	}
}
