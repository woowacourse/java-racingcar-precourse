package racingcar.domain.car;

public class CarNameLengthMustBetweenOneToFiveException extends IllegalArgumentException {

	private static final String message = "[ERROR] 자동차 이름의 길이는 1이상 5이하여야 한다.";

	public CarNameLengthMustBetweenOneToFiveException() {
		super(message);
	}
}
