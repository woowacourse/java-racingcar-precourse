package racingcar.validator;

public class CarNameValidator {
	static final int CAR_NAME_LENGTH = 5;
	static final String MSG_INVALID_LENGTH_ERROR = "[ERROR] 자동차 이름은 5자 이하만 가능하다.";
	static final String MSG_EMPTY_ERROR = "[ERROR] 자동차 이름은 공백일 수 없다.";

	public static void checkAll(String[] carNames) {
		for (String carName: carNames){
			checkLength(carName);
			IsEmpty(carName);
		}
	}

	private static void checkLength(String carName) {
		if (carName.length() > CAR_NAME_LENGTH) {
			throw new IllegalArgumentException(MSG_INVALID_LENGTH_ERROR);
		}
	}

	private static void IsEmpty(String carName) {
		if (carName.equals("")) {
			throw new IllegalArgumentException(MSG_EMPTY_ERROR);
		}
	}


}
