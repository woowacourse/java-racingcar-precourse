package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
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

	public static List<String> getWinners() {
		int maxPosition = 0;
		for (Car car : cars) {
			maxPosition = Math.max(car.getPosition(), maxPosition);
		}
		return findWinners(maxPosition);
	}

	private static List<String> findWinners(final int finalMaxPosition) {
		return cars.stream()
			.filter(car -> car.getPosition() == finalMaxPosition)
			.map(Car::getName)
			.collect(Collectors.toList());
	}
}
