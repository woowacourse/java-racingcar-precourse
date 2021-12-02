package racingcar.exception;

public class CarNameNotValidException extends IllegalArgumentException {
	private static final String MESSAGE = "[ERROR] 이름은 5자 이하만 가능하다.";

	public CarNameNotValidException() {
		System.out.println(MESSAGE);
	}
}
