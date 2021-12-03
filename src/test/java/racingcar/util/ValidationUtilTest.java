package racingcar.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidationUtilTest {

	@ParameterizedTest
	@ValueSource(strings = {"w ", "wq r", " w", " "})
	void 입력값에_대한_빈칸_예외_처리(String value) {
		assertThrows(IllegalArgumentException.class, () -> {
			ValidationUtil.isValidateBlank(value);
		});
	}

	@ParameterizedTest
	@ValueSource(strings = {""})
	void 입력값에_대한_공백_예외_처리(String value) {
		assertThrows(IllegalArgumentException.class, () -> {
			ValidationUtil.isValidateNotInput(value);
		});
	}

	@ParameterizedTest
	@ValueSource(strings = {"abcdef", "abcdefg"})
	void 입력값에_대한_길이_예외_처리(String value) {
		assertThrows(IllegalArgumentException.class, () -> {
			ValidationUtil.isValidateLength(value);
		});
	}

	@ParameterizedTest
	@ValueSource(strings = {"abcd,abcd"})
	void 입력값이_중복_된_경우_예외_처리(String value) {
		String[] inputArr = value.split(",");

		assertThrows(IllegalArgumentException.class, () -> {
			ValidationUtil.isValidateDuplicated(inputArr);
		});
	}

	@ParameterizedTest
	@ValueSource(strings = {"1a", "a1", "o"})
	void 시도횟수의_입력값이_숫자_형태가_아닌경우_예외_처리(String value) {
		assertThrows(IllegalArgumentException.class, () -> {
			ValidationUtil.isValidateNumber(value);
		});
	}

	@ParameterizedTest
	@ValueSource(strings = {"0"})
	void 시도횟수의_입력값이_최솟값_1이_아닌경우_예외_처리(String value) {
		assertThrows(IllegalArgumentException.class, () -> {
			ValidationUtil.isValidateMinimumOne(value);
		});
	}
}
