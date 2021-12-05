package racingcar.exception;

import static racingcar.common.constants.ExceptionConstants.*;

public class NotNumberException extends NumberFormatException{
	public NotNumberException() {
		super(NOT_NUMBER_COUNT_ERROR_MESSAGE);
	}
}
