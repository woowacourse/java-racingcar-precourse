package racingcar.domain.round;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingRoundTest {

	@Test
	@DisplayName("전진 시도 횟수는 0이면 안된다.")
	public void testCountWithZero() {
		// given
		int count = 0;
		// then
		assertThrows(IllegalArgumentException.class, () -> new RacingRound(count));
	}

	@Test
	@DisplayName("전진 시도 횟수는 음수면 안된다.")
	public void testCountWithNegative() {
		// given
		int count = -1;
		// then
		assertThrows(IllegalArgumentException.class, () -> new RacingRound(count));
	}

	@Test
	@DisplayName("카운트가 0 이하면 게임이 끝났음을 알린다.")
	public void testIsCountZeroGameOver() {
	    // given
	    int count = 1;
		RacingRound round = new RacingRound(count);
		// when
		round.decrease();
	    // then
		assertTrue(round.isOver());
	}
}