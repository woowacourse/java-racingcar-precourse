package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CarTest {

	@Test
	void move() {
		Car car = new Car("kim");
		car.move();
		assertTrue(car.isMoved());
	}
}
