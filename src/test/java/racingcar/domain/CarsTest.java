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
}
