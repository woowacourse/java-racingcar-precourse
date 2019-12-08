package domain;

import java.util.List;
import java.util.stream.Collectors;

public class CarManager {
	private final List<Car> cars;

	public CarManager(List<String> names) {
		cars = names.stream().map(Car::new).collect(Collectors.toList());
	}

	public List<Car> getCars() {
		return cars;
	}

	private Car getFirstMaxPositionCar() {
		return cars.stream()
				.max(Car::compareTo)
				.orElseThrow();
	}

	public List<Car> selectMaxPositionCars() {
		Car maxPositionCar = getFirstMaxPositionCar();
		return cars.stream()
				.filter(car -> car.isSamePosition(maxPositionCar))
				.collect(Collectors.toList());
	}

	public void update() {
		cars.forEach(Car::update);
	}
}
