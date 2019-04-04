/*
 * ParserTest.java
 */

package domain;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class ParserTest {
	private final static String testString = " apple, bad, cloud, delta, gamma";
	List<Car> testCarList1 = new ArrayList<Car>();

	{
		testCarList1.add(new Car("apple"));
		testCarList1.add(new Car("bad"));
		testCarList1.add(new Car("cloud"));
		testCarList1.add(new Car("delta"));
		testCarList1.add(new Car("gamma"));
	}

	@Test
	public void strToListOfCar() {
		assertEquals(testCarList1, Parser.strToListOfCar(testString));
	}

	@Test
	public void stringToInt() {
		assertEquals(5, Parser.strToInt("5"));
	}
}