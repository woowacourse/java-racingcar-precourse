package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTest {

	@Test
	void 자동차_전진() {
		// given
		Car car = Car.create("hello");
		assertThat(car.getPosition()).isEqualTo(0);

		// when
		car.goForward();

		// then
		assertThat(car.getPosition()).isEqualTo(1);
	}
}
