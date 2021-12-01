package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarTest {

	@Test
	void 자동차_전진_3_입력() {
		// given
		Car car = new Car("자동차");
		int previousCarPosition = car.getPosition();

		// when
		car.moveByNumber(3);

		// then
		Assertions.assertThat(car.getPosition()).isEqualTo(previousCarPosition);
	}

	@Test
	void 자동차_전진_4_입력() {
		// given
		Car car = new Car("자동차");
		int previousCarPosition = car.getPosition();

		// when
		car.moveByNumber(4);

		// then
		Assertions.assertThat(car.getPosition()).isGreaterThan(previousCarPosition);
	}
}
