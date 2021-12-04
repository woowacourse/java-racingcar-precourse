package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.util.NumberGeneratePolicy;

class CarsTest {

	@ParameterizedTest
	@ValueSource(strings = "hoon,ji,choi")
	void 등록된_자동차_전체의_운전_수행(String value) {
		// given
		Cars cars = Cars.fromString(value);
		NumberGeneratePolicy numberGeneratePolicy = new NumberGeneratePolicy() {
			@Override
			public int generateNumber() {
				return 4;
			}
		};

		// when
		cars.driveAll(numberGeneratePolicy);

		// then
		for (Car car : cars.getDriveRecord()) {
			assertEquals(car.getPosition(), 1);
		}
	}

	@ParameterizedTest
	@ValueSource(strings = "hoon,ji,choi")
	void 레이싱_게임_최종_라운드_후_우승자_판별(String value) {
		// given
		Cars cars = Cars.fromString(value);
		NumberGeneratePolicy numberGeneratePolicy = new NumberGeneratePolicy() {
			@Override
			public int generateNumber() {
				return 4;
			}
		};

		// when
		cars.driveAll(numberGeneratePolicy);

		// then
		for (Car winner : cars.getWinners()) {
			assertEquals(winner.getPosition(), 1);
		}
	}
}
