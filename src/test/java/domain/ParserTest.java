package domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ParserTest {
	private final static String testString = " apple, bad, cloud, delta, gamma,  ";
	List<Car> testCarList1 = new ArrayList<Car>();
	List<Car> testCarList2 = new ArrayList<Car>();

	{
		testCarList1.add(new Car("apple"));
		testCarList1.add(new Car("bad"));
		testCarList1.add(new Car("cloud"));
		testCarList1.add(new Car("delta"));
		testCarList1.add(new Car("gamma"));

		testCarList2.add(new Car("gold"));
	}

	@Test
	public void stringToListOfCar() {
		assertEquals(testCarList1, Parser.stringToListOfCar(testString));
		assertEquals(testCarList2, Parser.stringToListOfCar("gold, ,"));
	}

	@Test
	public void stringToInt() {
		assertEquals(5, Parser.stringToInt("5"));
		try {
			assertEquals(-1, Parser.stringToInt("a"));
		} catch (Exception e) {
			System.out.println("exception");
		}
	}
}