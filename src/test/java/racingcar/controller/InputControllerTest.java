package racingcar.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class InputControllerTest {
	@DisplayName("차 이름은 최소 2개 이상")
	@Nested
	class ValidateCarNameInput {
		@DisplayName("성공")
		@ParameterizedTest
		@ValueSource(strings = {"car1,car2", "car1,"})
		void success(String input) {
			InputController.validateContainDelimiter(input);
		}

		@DisplayName("실패")
		@ParameterizedTest
		@ValueSource(strings = {"car1", ""})
		void fail(String input) {
			assertThatThrownBy(() -> InputController.validateContainDelimiter(input))
				.isInstanceOf(IllegalArgumentException.class);
		}
	}
}
