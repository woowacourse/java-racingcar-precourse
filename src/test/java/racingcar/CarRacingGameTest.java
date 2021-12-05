package racingcar;

import org.junit.jupiter.api.Test;

class CarRacingGameTest {
	private InputValidator inputValidator = new InputValidator();

	@Test
	void isNameInputException() {
		String[] namesTrue = {"ab", "abc", "abcde"};
		assert inputValidator.isValidNamesInput(namesTrue) == true;

		String[] namesLengthFalse = {"ab", "abc", "abcdef"};
		assert inputValidator.isValidNamesInput(namesLengthFalse) == false;

		String[] namesDistinctFalse = {"ab", "abc", "abc"};
		assert inputValidator.isValidNamesInput(namesDistinctFalse) == false;
	}

	@Test
	void isRoundNumberInputException() {
		assert inputValidator.isValidNumberInput("2") == true;
		assert inputValidator.isValidNumberInput("0") == false;
		assert inputValidator.isValidNumberInput("two") == false;
	}

}