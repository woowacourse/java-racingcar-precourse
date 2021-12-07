package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
	@DisplayName("이름 유효성 검사")
	@Nested
	class ValidateName {
		@DisplayName("성공")
		@ParameterizedTest
		@ValueSource(strings = {"a", "carNa"})
		void success(String name) {
			new Car(name);
		}

		@DisplayName("실패")
		@ParameterizedTest
		@ValueSource(strings = {"", "carNam"})
		void fail(String name) {
			assertThatThrownBy(() -> new Car(name))
				.isInstanceOf(IllegalArgumentException.class);
		}
	}

}
