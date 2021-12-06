package racingcar.exception;

public class TurnCountTooSmallException extends IllegalArgumentException {
	public TurnCountTooSmallException(String message) {
		super(message);
	}
}
