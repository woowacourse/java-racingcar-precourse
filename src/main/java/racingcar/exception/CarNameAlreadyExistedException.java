package racingcar.exception;

public class CarNameAlreadyExistedException extends IllegalArgumentException {
	private static final String MESSAGE = "[ERROR] 중복된 이름은 사용할 수 없다.";

	public CarNameAlreadyExistedException() {
		System.out.println(MESSAGE);
	}
}
