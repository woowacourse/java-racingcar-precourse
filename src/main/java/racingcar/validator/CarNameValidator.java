package racingcar.validator;

public class CarNameValidator {
	static final int CAR_NAME_LENGTH = 5;

	public static void checkAll(String[] carNames) {
		for (String carName: carNames){
			checkLength(carName);
			IsEmpty(carName);
		}
	}

	private static void checkLength(String carName) {
		if (carName.length() > CAR_NAME_LENGTH) {
			throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이하만 가능하다.");
		}
	}

	private static void IsEmpty(String carName) {
		if (carName.equals("")) {
			throw new IllegalArgumentException("[ERROR] 자동차 이름은 공백일 수 없다.");
		}
	}
}
