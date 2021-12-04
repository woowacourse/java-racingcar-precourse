package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {
	private static final List<Car> cars = new ArrayList<>();

	private Cars() {}

	public static void addCar(Car car) {
		cars.add(car);
	}
}
