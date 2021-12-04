package racingcar.util;

public class Validation {

	public static void verifyCar(String[] cars) {
		for (String car:
			cars) {
			if (car.length() > 5) {
				throw(new IllegalArgumentException("자동차의 이름은 5자 이하여야 합니다."));
			}
		}
	}
}
