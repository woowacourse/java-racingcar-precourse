package racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarTest {

	private Car car;

	@BeforeEach
	void setUp() {
		car = new Car("philz");
	}

	@Test
	void 차_이동() {
		car.move(new FixedMovingStrategy(true));
		assertThat(car.getPosition()).isEqualTo(1);
	}

	@Test
	void 차_정지() {
		car.move(new FixedMovingStrategy(false));
		assertThat(car.getPosition()).isEqualTo(0);
	}

	@Test
	void 이름_5글자_초과시_예외() {
		assertThatThrownBy(() -> new Car("abcdef"))
			.isInstanceOf(RuntimeException.class)
			.hasMessage(Car.ERROR_OUT_OF_NAME_LENGTH);
	}
}