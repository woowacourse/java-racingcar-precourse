package racingcar.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RacingCarGameTest {
	private static Cars cars;

	@BeforeAll
	static void setupCars() {
		cars = Cars.generateCars("바흐,모차르트,쇼팽");
	}

	@ParameterizedTest
	@ValueSource(strings = {"0", "다섯", "04", "열3", "", "4 "})
	void validateRoundNumberTest(String roundNumber) {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			RacingCarGame racingCarGame = RacingCarGame.generateGame(roundNumber, cars);
		});
	}

}