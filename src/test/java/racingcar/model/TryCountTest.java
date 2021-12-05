package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TryCountTest {

	@DisplayName("1보다 작은 수를 입력할 경우 에러")
	@Test
	void exception_under1() {
		assertThatThrownBy(() -> new TryCount(0))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
