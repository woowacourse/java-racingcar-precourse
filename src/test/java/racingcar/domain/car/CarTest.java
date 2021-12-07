package racingcar.domain.car;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.domain.movement.InputMovementStrategy;
import racingcar.domain.movement.MovementStrategy;

class CarTest {
	@Test
	@DisplayName("자동차의 위치가 움직일 수 있다.")
	public void testCarMoveForward() throws Exception {
		// given
		int distance = 1;
		Car car = new Car("myCar");
		MovementStrategy strategy = new InputMovementStrategy(distance);
		// when
		car.move(strategy);
		// then
		assertEquals(car.toString(), "myCar : -");
	}
}