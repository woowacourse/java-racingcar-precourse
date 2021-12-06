package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;
import static racingcar.util.SymbolicConstantUtil.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.util.NumberGeneratePolicy;

class RacingGameTest {
	private static final int MOVING_FORWARD = 5;
	private NumberGeneratePolicy numberGeneratePolicy;

	@BeforeEach
	void 테스트용_숫자_생성_정책() {
		numberGeneratePolicy = () -> MOVING_FORWARD;
	}

	@ParameterizedTest
	@ValueSource(strings = "hoon,ji")
	void 자동차_경주_게임_기록_테스트(String value) {
		// given
		RacingGame racingGame = new RacingGame(value, 1, numberGeneratePolicy);

		// when
		RacingRecord racingRecord = racingGame.race();

		// then
		String[] carsName = value.split(COMMA);
		for (int index = 0; index < carsName.length; index++) {
			assertEquals(racingRecord.getRacingRecord().get(index).getPosition(), 1);
			assertEquals(racingRecord.getRacingRecord().get(index).getName(), carsName[index]);
		}
	}

	@ParameterizedTest
	@ValueSource(strings = "hoon,ji")
	void 자동차_경주_게임_결과_테스트(String value) {
		// given
		RacingGame racingGame = new RacingGame(value, 1, numberGeneratePolicy);
		racingGame.race();

		// when
		RacingResult racingResult = racingGame.getRacingResult();

		// then
		String[] carsName = value.split(COMMA);
		for (int index = 0; index < carsName.length; index++) {
			assertEquals(racingResult.getWinners().get(index).getPosition(), 1);
			assertEquals(racingResult.getWinners().get(index).getName(), carsName[index]);
		}
	}
}
