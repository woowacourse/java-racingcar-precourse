package domain;

import org.junit.Test;
import static org.junit.Assert.*;

public class CarTest {

	private final static int MOVE_LIMIT = 6;
	Car testCar = new Car("test");

	@Test
	public void testCarClass() {
		assertSame("test", testCar.getName());
		assertEquals(0, testCar.getPosition());
		while (testCar.getPosition() != MOVE_LIMIT) {
			testCar.moveCar();
			System.out.print(testCar.getPosition() + " ");
		}
		System.out.println();
	}

	@Test
	public void testRepeat() {
		int r;
		boolean flag = true;
		for (int i = 0; i < 1000; i++) {
			r = testCar.getRandomNumber();
			if ((r < 0) || (r >= 10)) {
				flag = false;
			}
		}
		assertTrue(flag);
	}
}

