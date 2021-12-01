package domain;

import java.util.Collections;
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

	public Winners getWinners() {
		Position maxPosition = getMaxPosition();
		Winners winnerNames = new Winners(this.cars.stream()
			.filter(car -> car.isSamePosition(maxPosition))
			.collect(Collectors.toList())
		);

		return winnerNames;
	}

	private Position getMaxPosition() {
		List<Position> positions = this.cars.stream()
			.map(Car::getPosition)
			.collect(Collectors.toList());

		return Collections.max(positions);
	}
}
