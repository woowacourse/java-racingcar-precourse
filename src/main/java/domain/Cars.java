package domain;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
	private final List<Car> cars;

	private Cars(List<Car> cars) {
		this.cars = cars;
	}

	public static Cars from(Names names) {
		List<Car> cars = names.getNames().stream()
			.map(Car::new)
			.collect(Collectors.toList());

		return new Cars(cars);
	}

	public List<Car> getCars() {
		return this.cars;
	}

	public void moveAll() {
		cars.forEach(Car::moveForward);
	}
}
