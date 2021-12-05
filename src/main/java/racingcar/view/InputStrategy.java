package racingcar.view;

import java.util.regex.Pattern;

import racingcar.domain.Cars;

public interface InputStrategy {

	String ERROR_INPUT_TRY_NUMBER = "[ERROR] 입력한 시도 횟수가 올바르지 않습니다.";

	Cars getCars();

	int getTryNumber();

	default void validateTryNumber(String inputTryNumber) {
		try {
			Integer.parseInt(inputTryNumber);
		} catch (Exception exception) {
			throw new IllegalArgumentException(ERROR_INPUT_TRY_NUMBER);
		}
	}
}
