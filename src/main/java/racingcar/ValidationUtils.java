package racingcar;

import java.util.List;

import racingcar.domain.NumberRange;

public class ValidationUtils {

	private static final int MAX_LENGTH_CAR_NAME = 5;
	private static final String NUMBER_ERROR_MESSAGE = "[ERROR] 시도 횟수는 숫자여야 한다.";
	private static final String NOT_POSITIVE_ERROR_MESSAGE = "[ERROR] 시도 횟수는 양수여야 한다.";
	private static final String NAME_OUT_OF_RANGE_ERROR_MESSAGE = "[ERROR] 자동차 이름은 5자 이하만 가능하다.";

	public static boolean validNoRange(int No) {
		return No >= NumberRange.MIN_NO.getValue() && No <= NumberRange.MAX_NO.getValue();
	}

	public static boolean validNumber(String input) {
		try {
			Integer.parseInt(input);
		} catch (NumberFormatException e) {
			System.out.println(NUMBER_ERROR_MESSAGE);
			return false;
		}
		return true;
	}

	public static boolean validPositive(String input) {

		if (Integer.parseInt(input) <= 0) {
			System.out.println(NOT_POSITIVE_ERROR_MESSAGE);
			return false;
		}
		return true;
	}

	public static boolean validCarName(String testCarName) {
		if (testCarName.length() > MAX_LENGTH_CAR_NAME) {
			System.out.println(NAME_OUT_OF_RANGE_ERROR_MESSAGE);
			return false;
		}
		return true;
	}

	public static boolean validCarList(List<String> carList) {
		for (String car : carList) {
			if (!validCarName(car)) {
				return false;
			}
		}
		return true;
	}
}
