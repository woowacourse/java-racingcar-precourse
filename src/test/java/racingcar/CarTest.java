package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CarTest {
	@Test
	void 자동차_이름_5자_초과() {
		assertThatThrownBy(() -> new Car("exception"))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
