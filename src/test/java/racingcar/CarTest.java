package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarTest {
	Car car;

	@BeforeEach
	void setUp() {
		car = new Car("car");
	}

	@Test
	void 자동차_이름_5자_초과() {
		assertThatThrownBy(() -> new Car("exception"))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 자동차는_4이상이면_전진한다() {
		car.controlByNumber(4);

		assertThat(car.getPosition()).isEqualTo(1);
	}

	@Test
	void 자동차는_4미만이면_정지한다() {
		car.controlByNumber(3);

		assertThat(car.getPosition()).isEqualTo(0);
	}
}
