package racingcar.exception;

import static racingcar.common.constants.ExceptionConstants.*;

public class OverMaxLengthException extends IllegalArgumentException{
	public OverMaxLengthException() {
		super(OVER_FIVE_WORDS_ERROR_MESSAGE);
	}
}
