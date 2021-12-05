package racingcar.domain;

import java.util.List;

public class Cars {

	private final List<Car> cars;

	public Cars(List<Car> cars) {
		this.cars = cars;
	}

	public void move() {
		cars.forEach(Car::move);
	}
}
