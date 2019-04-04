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
	}
}

