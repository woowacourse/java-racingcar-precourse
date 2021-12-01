package racingcar.domain;

import static racingcar.constant.GameConstants.Car.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarTest {
	private static final String carName = "자1동차";
	Car car;

	@BeforeEach
	void setUp() {
		car = new Car(carName);
	}

	@Test
	void 자동차_전진_3_입력() {
		// given
		int previousCarPosition = car.getPosition();

		// when
		car.moveByNumber(3);

		// then
		Assertions.assertThat(car.getPosition()).isEqualTo(previousCarPosition);
	}

	@Test
	void 자동차_전진_4_입력() {
		// given
		int previousCarPosition = car.getPosition();

		// when
		car.moveByNumber(4);

		// then
		Assertions.assertThat(car.getPosition()).isGreaterThan(previousCarPosition);
	}

	@Test
	void 자동차_문자열_변환() {
		// given, when
		car.moveByNumber(MOVE_CRITERION_INCLUSIVE.getValue());

		// then
		Assertions.assertThat(car.toString()).isEqualTo(carName + " : -");
	}
}
