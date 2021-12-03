package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CarTest {

	@Test
	void move() {
		Car move = new Car("move");
		move.move(4);
		assertTrue(move.isMoved());

		Car noMove = new Car("noMove");
		noMove.move(3);
		assertFalse(noMove.isMoved());
	}
}
