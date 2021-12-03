package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

	@ParameterizedTest
	@ValueSource(ints = {4, 5})
	void 값이_4이상인_경우_전진기능(int value) {
		// given
		Car car = new Car("qwer");

		// when
		car.drive(value);

		// then
		assertEquals(car.getPosition(), 1);
	}
}
