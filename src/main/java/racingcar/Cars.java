package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import racingcar.util.Assertions;

public class Cars {
	private static final List<Car> cars = new ArrayList<>();

	private Cars() {}

	public static void addCar(Car car) {
		Assertions.throwExceptionIsTrue(cars.contains(car), ErrorInfo.OVERLAP);
		cars.add(car);
	}

	public static boolean isReady() {
		return !cars.isEmpty();
	}

	public static List<Car> getCars() {
		return Collections.unmodifiableList(cars);
	}
}
