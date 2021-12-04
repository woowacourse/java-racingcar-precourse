package racingcar.validation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NameValidationTest {

	@Test
	void 이름_중복_예외테스트() {
		// given
		String[] nameList = {"pobi", "jun", "jun"};

		// then
		assertThrows(IllegalArgumentException.class, () -> NameValidation.validateName(nameList));
	}

	@Test
	void 공백_입력_예외테스트() {
		// given
		String[] nameList = {"pobi", "jun", ""};

		// then
		assertThrows(IllegalArgumentException.class, () -> NameValidation.validateName(nameList));
	}

	@Test
	void 글자수_예외테스트() {
		// given
		String[] nameList = {"pobi", "jun", "javaji"};

		// then
		assertThrows(IllegalArgumentException.class, () -> NameValidation.validateName(nameList));
	}
}
