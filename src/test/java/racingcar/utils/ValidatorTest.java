package racingcar.utils;

import static org.junit.jupiter.api.Assertions.*;
import static racingcar.utils.Validator.*;

import org.junit.jupiter.api.Test;

class ValidatorTest {
	@Test
	void 이름_예외_검사() {
		// given
		String[] longName = "LongName".split(",");
		String[] startWithComma = ",Kim,Lee".split(",");
		String[] endWithComma = "Kim,Lee,".split(",", -1);
		String[] containBlank = "Kim, ,Lee".split(",");

		// when, then
		assertAll(
			() -> assertThrows(IllegalArgumentException.class, () -> validateNameInput(longName)),
			() -> assertThrows(IllegalArgumentException.class, () -> validateNameInput(startWithComma)),
			() -> assertThrows(IllegalArgumentException.class, () -> validateNameInput(endWithComma)),
			() -> assertThrows(IllegalArgumentException.class, () -> validateNameInput(containBlank))
		);
	}

	@Test
	void 숫자_예외_검사() {
		// given
		String notNumber = "notNumber";

		// when, then
		assertThrows(IllegalArgumentException.class, () -> validateNumberInput(notNumber));
	}
}