package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import racingcar.reader.RacingInfo;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

public class RacingGameTest {
	static final int MOVE_NUMBER = 5;
	static final int STOP_NUMBER = 1;

	MockedStatic<Randoms> mockedStatic;

	@BeforeEach
	public void setUp() throws Exception {
		mockedStatic = mockStatic(Randoms.class);
	}

	@AfterEach
	public void tearDown() throws Exception {
		mockedStatic.close();
	}

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

	@Test
	@DisplayName("중간 결과 반환")
	void return_proceed_result() {
		when(Randoms.pickNumberInRange(0, 9))
			.thenReturn(MOVE_NUMBER).thenReturn(STOP_NUMBER).thenReturn(STOP_NUMBER)
			.thenReturn(MOVE_NUMBER).thenReturn(MOVE_NUMBER).thenReturn(STOP_NUMBER)
			.thenReturn(MOVE_NUMBER).thenReturn(STOP_NUMBER).thenReturn(MOVE_NUMBER);
		RacingGame racingGame = RacingGame.of(RacingInfo.of(3, Arrays.asList("pobi", "woni", "jun")));

		assertThat(racingGame.proceed()).containsExactlyInAnyOrder(
			ProceedResult.of("pobi", 1), ProceedResult.of("woni", 0), ProceedResult.of("jun", 0));
		assertThat(racingGame.proceed()).containsExactlyInAnyOrder(
			ProceedResult.of("pobi", 2), ProceedResult.of("woni", 1), ProceedResult.of("jun", 0));
		assertThat(racingGame.proceed()).containsExactlyInAnyOrder(
			ProceedResult.of("pobi", 3), ProceedResult.of("woni", 1), ProceedResult.of("jun", 1));
	}

	@Test
	@DisplayName("단독 우승자 반환")
	void return_single_winners() {
		when(Randoms.pickNumberInRange(0, 9))
			.thenReturn(MOVE_NUMBER).thenReturn(STOP_NUMBER).thenReturn(STOP_NUMBER)
			.thenReturn(MOVE_NUMBER).thenReturn(MOVE_NUMBER).thenReturn(STOP_NUMBER)
			.thenReturn(MOVE_NUMBER).thenReturn(STOP_NUMBER).thenReturn(MOVE_NUMBER);
		RacingGame racingGame = RacingGame.of(RacingInfo.of(3, Arrays.asList("pobi", "woni", "jun")));

		while (!racingGame.isFinished()) {
			racingGame.proceed();
		}

		assertThat(racingGame.getWinners()).containsExactlyInAnyOrder("pobi");
	}

	@Test
	@DisplayName("공동 우승자 반환")
	void return_cowinners() {
		when(Randoms.pickNumberInRange(0, 9))
			.thenReturn(MOVE_NUMBER).thenReturn(STOP_NUMBER).thenReturn(STOP_NUMBER)
			.thenReturn(STOP_NUMBER).thenReturn(MOVE_NUMBER).thenReturn(STOP_NUMBER)
			.thenReturn(MOVE_NUMBER).thenReturn(MOVE_NUMBER).thenReturn(MOVE_NUMBER);
		RacingGame racingGame = RacingGame.of(RacingInfo.of(3, Arrays.asList("pobi", "woni", "jun")));

		while (!racingGame.isFinished()) {
			racingGame.proceed();
		}

		assertThat(racingGame.getWinners()).containsExactlyInAnyOrder("pobi", "woni");
	}
}