/*
 * CarTest.java
 */

package domain;

import org.junit.Test;
import static org.junit.Assert.*;

public class CarTest {
	Car testCar = new Car("test");

	@Test
	public void testCarClass() {
		assertSame("test", testCar.getName());
		assertEquals(0, testCar.getPosition());
	}
}

