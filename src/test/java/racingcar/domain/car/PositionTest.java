package racingcar.domain.car;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {

	@Test
	@DisplayName("위치는 0 이상이 될 수 있다.")
	public void testPositionPositive() {
	    // given
		int pos = 0;
	    // then
		assertDoesNotThrow(() -> new Position(pos));
	}

	@Test
	@DisplayName("위치는 0 미만이 될 수 없다.")
	public void testPositionNegative() {
	    // given
		int pos = -1;
	    // when
		assertThrows(IllegalArgumentException.class, () -> new Position(pos));
	    // then
	}
}