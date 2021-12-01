package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
	protected final List<Car> cars;

	public Cars(List<String> cars) {
		this.cars = mapCar(cars);
	}

	private List<Car> mapCar(List<String> cars) {
		return cars.stream().map(Car::new).collect(Collectors.toList());
	}
}
