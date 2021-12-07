package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {
	Car car;

	@BeforeEach
	void setupCar() {
		car = new Car("이것은차다");
	}

	@ParameterizedTest
	@ValueSource(ints = {4, 5, 6, 7, 8, 9})
	void isMovableWhenRandomNumberGreaterThanOrEqualToThreshold(int randomNumber) {
	}

	@ParameterizedTest
	@ValueSource(ints = {0, 1, 2, 3})
	void isMovedWhenRandomNumberGreaterLessThanThreshold(int randomNumber) {

	}
}