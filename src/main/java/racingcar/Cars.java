package racingcar;

import java.util.List;
import java.util.stream.Collectors;


public class Cars {
	private final List<Car> cars;

	private Cars(List<Car> cars) {
		this.cars = cars;
	}

	@Override
	public String toString() {
		return cars.stream()
			.map(Car::toString)
			.collect(Collectors.joining("\n"));
	}
}
