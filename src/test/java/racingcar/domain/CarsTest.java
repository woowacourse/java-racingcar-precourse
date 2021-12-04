package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;
import static racingcar.util.SymbolicConstantUtil.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.util.NumberGeneratePolicy;

class CarsTest {
	private static final int MOVING_FORWARD = 5;
	private NumberGeneratePolicy numberGeneratePolicy;

	@BeforeEach
	void 테스트용_숫자_생성_정책() {
		numberGeneratePolicy = new NumberGeneratePolicy() {
			@Override
			public int generateNumber() {
				return MOVING_FORWARD;
			}
		};
	}

	@ParameterizedTest
	@ValueSource(strings = "hoon,ji,choi")
	void 등록된_자동차_전체의_운전_수행(String value) {
		// given
		Cars cars = Cars.fromString(value);

		// when
		cars.driveAll(numberGeneratePolicy);

		// then
		String[] carsName = value.split(COMMA);
		for (int index = 0; index < carsName.length; index++) {
			assertEquals(cars.getDriveRecord().get(index).getPosition(), 1);
			assertEquals(cars.getDriveRecord().get(index).getName(), carsName[index]);
		}
	}

	@ParameterizedTest
	@ValueSource(strings = "hoon,ji")
	void 레이싱_게임_최종_라운드_후_우승자_판별(String value) {
		// given
		Cars cars = Cars.fromString(value);

		// when
		cars.driveAll(numberGeneratePolicy);

		// then
		String[] carsName = value.split(COMMA);
		for (int index = 0; index < carsName.length; index++) {
			assertEquals(cars.getWinners().get(index).getPosition(), 1);
			assertEquals(cars.getWinners().get(index).getName(), carsName[index]);
		}
	}
}
