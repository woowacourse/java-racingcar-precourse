package domain;

import java.util.List;
import java.util.stream.Collectors;

public class CarManager {
	private final List<Car> cars;

	public CarManager(List<String> names) {
		cars = names.stream().map(Car::new).collect(Collectors.toList());
	}

	public void update() {
		cars.forEach(Car::update);
	}

	private Car getFirstMaxPositionCar() {
		return cars.stream()
				.max(Car::compareTo)
				.orElseThrow();
	}
}
