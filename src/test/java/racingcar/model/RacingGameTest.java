package racingcar.model;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.reader.RacingInfo;
import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
	@Test
	@DisplayName("주어진 횟수만큼 경기를 진행")
	void proceed_until_turn_value() {
		RacingGame racingGame = RacingGame.of(RacingInfo.of(3, Arrays.asList("pobi", "woni", "jun")));

		assertThat(racingGame.isFinished()).isFalse();
		racingGame.proceed();
		assertThat(racingGame.isFinished()).isFalse();
		racingGame.proceed();
		assertThat(racingGame.isFinished()).isFalse();
		racingGame.proceed();
		assertThat(racingGame.isFinished()).isTrue();
	}
}