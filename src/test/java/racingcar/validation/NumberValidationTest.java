package racingcar.validation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NumberValidationTest {

	@Test
	void 입력숫자_예외테스트() {
		// given
		String input1 = "0";
		String input2 = "";
		String input3 = " ";
		String input4 = "10";
		String input5 = "a";
		String input6 = "%";

		// then
		assertThrows(IllegalArgumentException.class, () -> NumberValidation.validateInputNumber(input1));
		assertThrows(IllegalArgumentException.class, () -> NumberValidation.validateInputNumber(input2));
		assertThrows(IllegalArgumentException.class, () -> NumberValidation.validateInputNumber(input3));
		assertThrows(IllegalArgumentException.class, () -> NumberValidation.validateInputNumber(input4));
		assertThrows(IllegalArgumentException.class, () -> NumberValidation.validateInputNumber(input5));
		assertThrows(IllegalArgumentException.class, () -> NumberValidation.validateInputNumber(input6));
	}
}
