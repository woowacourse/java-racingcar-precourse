package racingcar.view;

import java.util.regex.Pattern;

import racingcar.domain.Cars;

public interface InputStrategy {

	String ERROR_INPUT_CAR_NAMES = "입력한 자동차의 값이 올바르지 않습니다.";
	String ERROR_INPUT_TRY_NUMBER = "입력한 시도 횟수가 올바르지 않습니다.";

	Cars getCars();

	int getTryNumber();

	default void validateCarNames(String carNamesInput) {
		String regex = "\\w*\\,\\w*\\,\\w*";
		boolean matches = Pattern.matches(regex, carNamesInput);
		if (!matches) {
			throw new IllegalArgumentException(ERROR_INPUT_CAR_NAMES);
		}
	}

	default void validateTryNumber(String inputTryNumber) {
		try {
			Integer.parseInt(inputTryNumber);
		} catch (Exception exception) {
			throw new IllegalArgumentException(ERROR_INPUT_TRY_NUMBER);
		}
	}
}
