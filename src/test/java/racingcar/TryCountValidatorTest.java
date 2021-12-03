package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TryCountValidatorTest {

	@DisplayName("1보다 작은 수를 입력할 경우 에러")
	@Test
	void exception_under1() {
		assertThatThrownBy(() -> TryCountValidator.validate(0))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
