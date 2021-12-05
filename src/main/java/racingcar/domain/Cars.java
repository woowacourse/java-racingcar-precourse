package racingcar.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Cars {

	private final List<Car> cars;

	public Cars(List<Car> cars) {
		this.cars = cars;
	}

	public void move() {
		cars.forEach(Car::move);
	}

	public Map<String, Integer> makeRoundResult() {
		return cars.stream()
			.collect(Collectors
				.toMap(Car::getName, Car::getPosition));
	}
}
