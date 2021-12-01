package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidationUtilsTest {
	@Test
	@DisplayName("0~9 숫자 테스트")
	void validNo_test() {
		assertThat(ValidationUtils.validNo(0)).isTrue();
		assertThat(ValidationUtils.validNo(9)).isTrue();
		assertThat(ValidationUtils.validNo(-1)).isFalse();
		assertThat(ValidationUtils.validNo(10)).isFalse();
	}

	@Test
	@DisplayName("숫자인지 체크")
	void isNumber_test() {
		assertThat(ValidationUtils.isNumber("a1")).isFalse();
		assertThat(ValidationUtils.isNumber("a")).isFalse();
	}
}
