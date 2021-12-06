package racingcar.car;

import java.util.List;

public class CarCarrier {
	List<Car> cars;

	public CarCarrier(List<Car> cars) {
		this.cars = cars;
	}

	public List<Car> getCars() {
		return cars;
	}
}
