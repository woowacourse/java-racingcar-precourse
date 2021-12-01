package domain;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
	private final List<Car> cars;

	public Cars(Names names) {
		this.cars = names.getNames().stream()
			.map(Car::new)
			.collect(Collectors.toList());
	}

	public List<Car> getCars() {
		return this.cars;
	}

	public void moveAll() {
		cars.forEach(Car::moveForward);
	}
}
