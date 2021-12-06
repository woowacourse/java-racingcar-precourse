package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;
import static racingcar.util.SymbolicConstantUtil.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.util.NumberGeneratePolicy;

class CarsTest {
	private static final int MOVING_FORWARD = 5;
	private NumberGeneratePolicy numberGeneratePolicy;
	private List<Car> carList = new ArrayList<>();

	@BeforeEach
	void 테스트용_숫자_생성_정책() {
		setUpDriveAllTest();
		setUpGetWinners();
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

	@Test
	void 레이싱_게임_최종_라운드_후_우승자_판별() {
		// given
		Cars cars = new Cars(carList);

		// when
		List<Car> winnerCars = cars.getWinners();

		// then
		assertEquals(winnerCars.size(), 2);
		assertEquals(winnerCars.get(0).getPosition(), 2);
		assertEquals(winnerCars.get(0).getName(), "hoon");
		assertEquals(winnerCars.get(1).getName(), "ji");
	}

	private void setUpDriveAllTest() {
		numberGeneratePolicy = () -> MOVING_FORWARD;
	}

	private void setUpGetWinners() {
		Car carA = new Car("hoon");
		Car carB = new Car("ji");
		Car carC = new Car("bab");

		carA.drive(MOVING_FORWARD);
		carA.drive(MOVING_FORWARD);
		carB.drive(MOVING_FORWARD);
		carB.drive(MOVING_FORWARD);

		carList.add(carA);
		carList.add(carB);
		carList.add(carC);
	}
}
