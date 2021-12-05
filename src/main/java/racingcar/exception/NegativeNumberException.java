package racingcar.exception;

import static racingcar.common.constants.ExceptionConstants.*;

public class NegativeNumberException extends IllegalArgumentException{
	public NegativeNumberException() {
		super(NOT_NUMBER_COUNT_ERROR_MESSAGE);
	}
}
