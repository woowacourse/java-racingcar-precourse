package racingcar.util;

public class Validation {

	public static void verifyCar(String[] cars) {
		for (String car:
			cars) {
			if (car.length() > 5) {
				throw(new IllegalArgumentException("자동차의 이름은 5자 이하여야 한다."));
			}
		}
	}

	public static void verifyMove(String moveCount) {
		try {
			Integer.parseInt(moveCount);
		} catch (NumberFormatException numberFormatException) {
			throw (new IllegalArgumentException("시도 횟수는 숫자여야 한다."));
		}
	}
}
