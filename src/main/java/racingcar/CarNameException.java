package racingcar;

public class CarNameException {
	private static final int LIMIT_CAR_NAME_SIZE = 5;
	private static final int NO_NAME = 0;

	private static final String CAR_NAME_LENGTH_ERROR_MESSAGE_1 = "[ERROR] 자동차 이름은 ";
	private static final String CAR_NAME_LENGTH_ERROR_MESSAGE_2 = "자 이하, 0자 이상만 가능하다.";

	private String[] carNames;

	public CarNameException(String[] carNames) {
		this.carNames = carNames;
	}

	private boolean checkCarNameSizeException(String carName) {

		try {

			if (carName.length() > LIMIT_CAR_NAME_SIZE || carName.length() == NO_NAME) {
				throw new IllegalArgumentException();
			}

		} catch (IllegalArgumentException e) {
			System.out.println(CAR_NAME_LENGTH_ERROR_MESSAGE_1 + LIMIT_CAR_NAME_SIZE + CAR_NAME_LENGTH_ERROR_MESSAGE_2);
			return false;
		}

		return true;
	}

}
