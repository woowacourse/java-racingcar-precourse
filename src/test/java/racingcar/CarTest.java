package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.domain.Car;
import racingcar.domain.CarPosition;

public class CarTest {
	@Test
	@DisplayName("randNo >= 4 이면 true")
	void is_forward_test() {
		assertThat(Car.isForward(4)).isTrue();
		assertThat(Car.isForward(9)).isTrue();
		assertThat(Car.isForward(0)).isFalse();
	}

	@Test
	@DisplayName("전진 테스트")
	void forward_test() {
		Car testCar = new Car("testCar");
		CarPosition testPosition = new CarPosition(1);
		testCar.forward();
		assertThat(testCar.getPosition().equals(testPosition)).isTrue();
	}
}
