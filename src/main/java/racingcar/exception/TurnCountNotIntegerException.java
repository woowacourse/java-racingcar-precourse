package racingcar.exception;

public class TurnCountNotIntegerException extends IllegalArgumentException {
	public TurnCountNotIntegerException(String message) {
		super(message);
	}
	public TurnCountNotIntegerException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
