package racingcar.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarPowerTest {

	@DisplayName("4 이상인 경우만 잘 움직여지는지 테스트")
	@Test
	void canMove() {
		CarPower canMove = new CarPower(4);
		CarPower noMove = new CarPower(3);
		assertAll(
			() -> assertTrue(canMove.canMove()),
			() -> assertFalse(noMove.canMove())
		);
	}
}
