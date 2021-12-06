package racingcar.exception;

public class NameContainsEmptyStringException extends IllegalArgumentException {
	public NameContainsEmptyStringException(String message) {
		super(message);
	}
}
