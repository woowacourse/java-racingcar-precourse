package racingcar;

import java.util.ArrayList;
import java.util.List;
import racingcar.util.Assertions;

public class Cars {
	private static final List<Car> cars = new ArrayList<>();

	private Cars() {}

	public static void addCar(Car car) {
		Assertions.throwExceptionIsTrue(cars.contains(car), ErrorInfo.OVERLAP);
		cars.add(car);
	}
}
