package racingcar.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static racingcar.controller.InputController.*;

public class InputValidationTest {
	@DisplayName("자동차 이름 입력")
	@Nested
	class CarName {
		@DisplayName("지정된 구분자가 없을 시 예외 발생")
		@ParameterizedTest
		@ValueSource(strings = {"car1", "car1car2"})
		void validateContainDelimiter(String input) {
			assertThatThrownBy(() ->
				InputValidation.validateContainDelimiter(input)
			).isInstanceOf(IllegalArgumentException.class);
		}

		@DisplayName("이름의 개수는 2개 미만일 때 예외 발생")
		@ParameterizedTest
		@ValueSource(strings = {"car1,", "car1", ""})
		void validateSize(String input) {
			String[] names = input.split(NAME_DELIMITER);
			assertThatThrownBy(() ->
				InputValidation.validateSize(names)
			).isInstanceOf(IllegalArgumentException.class);
		}
	}

	@DisplayName("회수 입력")
	@Nested
	class Count {
		@DisplayName("0입력시 예외 발생")
		@Test
		void validateIsZero() {
			assertThatThrownBy(() ->
				InputValidation.validateIsZero("0")
			).isInstanceOf(IllegalArgumentException.class);
		}

		@DisplayName("숫자 이외의 값 입력시 예외 발생")
		@ParameterizedTest
		@ValueSource(strings = {"a", "12a", "-1"})
		void validateIsNumber(String input) {
			assertThatThrownBy(() ->
				InputValidation.validateIsNumber(input)
			).isInstanceOf(IllegalArgumentException.class);
		}
	}
}
