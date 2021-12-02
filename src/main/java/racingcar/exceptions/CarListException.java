package racingcar.exceptions;

public class CarListException {
	private static String ERROR_MESSAGE_OVER = "[ERROR] 자동차 이름은 공백을 포함하여 5자리를 넘을 수 없습니다.\n";
	private static String ERROR_MESSAGE_NULL = "[ERROR] 자동차 이름은 공백을 제외하고 최소 한자리 이상이어야 합니다.\n";

	public static void carListException(String[] carArray) {
		for (String car : carArray) {
			checkCarNameLength(car);
		}
	}

	private static void checkCarNameLength(String car) {
		int carLength = car.length();
		if (carLength > 5) {
			throw new IllegalArgumentException(ERROR_MESSAGE_OVER);
		}

		isEmpty(car);
	}

	private static void isEmpty(String car) {
		int carLengthWithoutSpace = car.trim().length();
		if (carLengthWithoutSpace == 0) {
			throw new IllegalArgumentException(ERROR_MESSAGE_NULL);
		}
	}

}
