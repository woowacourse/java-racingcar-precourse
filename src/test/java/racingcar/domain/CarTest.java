package racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTest {

	@Test
	void 자동차_전진() {
		// given
		Car car = Car.createCar("hello");
		assertThat(car.getPosition()).isEqualTo(0);

		// when
		car.goForward();

		// then
		assertThat(car.getPosition()).isEqualTo(1);
	}

	@Test
	void 자동차_이름_예외_검증() {
		assertThrows(IllegalArgumentException.class, () -> Car.createCar(""));
		assertThrows(IllegalArgumentException.class, () -> Car.createCar("starbucks"));
		assertThrows(IllegalArgumentException.class, () -> Car.createCar("!@#$"));
		assertThrows(IllegalArgumentException.class, () -> Car.createCar("a b"));
	}
}
