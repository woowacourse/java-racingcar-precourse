package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {

	private final List<Car> cars;

	public Cars(List<Car> cars) {
		this.cars = cars;
	}

	public List<Result> getRoundResult() {
		return cars.stream()
			.map(Result::new)
			.collect(Collectors.toList());
	}

	public void move() {
		cars.forEach(Car::move);
	}
}
