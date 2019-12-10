package com.woowacourse.racingcar.validator;

/**
 * @version 1.0.0
 * @author KSKIM
 * @since 2019-12-09
 */
public class InputValidator {
	private static final String CAR_NAMES_PATTERN = "^(\\s)*([\\w]){1,5}(\\s)*(,(\\s)*([\\w]){1,5}(\\s)*)*$";

	public static boolean isValidNames(String input) {
		return input.matches(CAR_NAMES_PATTERN);
	}
}
