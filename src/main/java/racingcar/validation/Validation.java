package racingcar.validation;

import java.util.List;

import racingcar.domain.Car;
import racingcar.exception.ErrorMessage;

public class Validation {

	public static void checkCarNameLength(String car) {
		if (car.length() > 5) {
			throw new IllegalArgumentException(ErrorMessage.CAR_NAME_LENGTH_ERROR.getErrorMessage());
		}
	}

	public static void checkNull(String inputStr) {
		if (inputStr.length() == 0 || inputStr.isEmpty()) {
			throw new IllegalArgumentException(ErrorMessage.NULL_ERROR.getErrorMessage());
		}
	}

	public static void checkDistinctCarNames(List<Car> carList) {
		if (carList.stream().distinct().count() != carList.size()) {
			throw new IllegalArgumentException(ErrorMessage.CAR_NAME_DISTINCT_ERROR.getErrorMessage());
		}
	}

	public static void checkCarIsOne(String inputStr) {
		if (inputStr.split(",").length == 1) {
			throw new IllegalArgumentException(ErrorMessage.CAR_NAME_ONE_ERROR.getErrorMessage());
		}
	}

	public static void checkInputIsPositiveNumber(String inputStr) {
		for (char c : inputStr.toCharArray()) {
			if (!Character.isDigit(c) || c - '0' <= 0) {
				throw new IllegalArgumentException(ErrorMessage.NOT_CORRECT_REPEAT_NUM_ERROR.getErrorMessage());
			}
		}
	}
}
