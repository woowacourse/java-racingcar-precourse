package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import racingcar.util.NumberGeneratePolicy;

class RacingGameTest {
	private NumberGeneratePolicy numberGeneratePolicy;

	@BeforeEach
	void 테스트용_숫자_생성_정책() {
		numberGeneratePolicy = new NumberGeneratePolicy() {
			@Override
			public int generateNumber() {
				return 5;
			}
		};
	}

	@Test
	void 자동차_경주_게임_기록_테스트() {
		// given
		RacingGame racingGame = new RacingGame("test1,test2", 1, numberGeneratePolicy);

		// when
		RacingRecord racingRecord = racingGame.race();

		// then
		assertEquals(racingRecord.getRacingRecord().get(0).getPosition(), 1);
		assertEquals(racingRecord.getRacingRecord().get(0).getName(), "test1");
		assertEquals(racingRecord.getRacingRecord().get(1).getPosition(), 1);
		assertEquals(racingRecord.getRacingRecord().get(1).getName(), "test2");
	}

	@Test
	void 자동차_경주_게임_결과_테스트() {
		// given
		RacingGame racingGame = new RacingGame("test1,test2", 1, numberGeneratePolicy);
		racingGame.race();

		// when
		RacingResult racingResult = racingGame.getRacingResult();

		// then
		assertEquals(racingResult.getWinners().get(0).getPosition(), 1);
		assertEquals(racingResult.getWinners().get(0).getName(), "test1");
		assertEquals(racingResult.getWinners().get(1).getPosition(), 1);
		assertEquals(racingResult.getWinners().get(1).getName(), "test2");
	}
}
