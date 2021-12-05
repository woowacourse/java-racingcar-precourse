package racingcar.exception;

import static racingcar.common.constants.ExceptionConstants.*;

public class OverMaxLengthOfException extends IllegalArgumentException{
	public OverMaxLengthOfException() {
		super(OVER_FIVE_WORDS_ERROR_MESSAGE);
	}
}
