package domain;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class OutputViewTest {
	List<Car> testCarList1 = new ArrayList<Car>();

	{
		testCarList1.add(new Car("apple"));
		testCarList1.add(new Car("bad"));
		testCarList1.add(new Car("cloud"));
		testCarList1.add(new Car("delta"));
		testCarList1.add(new Car("gamma"));
	}

	@Test
	public void printGame() {
		OutputView.printGame(testCarList1, 6);
	}
}