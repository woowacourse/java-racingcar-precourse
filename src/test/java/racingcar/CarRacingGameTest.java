package racingcar;

import org.junit.jupiter.api.Test;

import racingcar.validation.CarNamesValidator;
import racingcar.validation.RoundNumberValidator;

class CarRacingGameTest {
	private static final CarNamesValidator namesValidator = new CarNamesValidator();
	private static final RoundNumberValidator numberValidator = new RoundNumberValidator();

	@Test
	void isNameInputException() {
		String[] namesTrue = {"ab", "abc", "abcde"};
		assert namesValidator.isValidNamesInput(namesTrue) == true;

		String[] namesLengthFalse = {"ab", "abc", "abcdef"};
		assert namesValidator.isValidNamesInput(namesLengthFalse) == false;

		String[] namesDistinctFalse = {"ab", "abc", "abc"};
		assert namesValidator.isValidNamesInput(namesDistinctFalse) == false;
	}

	@Test
	void isRoundNumberInputException() {
		assert numberValidator.isValidNumberInput("2") == true;
		assert numberValidator.isValidNumberInput("0") == false;
		assert numberValidator.isValidNumberInput("two") == false;
	}

}