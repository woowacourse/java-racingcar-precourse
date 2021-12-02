package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class CarRepository {
	List<Car> carList = new ArrayList<>();

	public void createCars(String[] names) {
		for (String name: names) {
			carList.add(new Car(name));
		}
	}

	public void attemptCarsMoving() {
		for (Car car: carList) {
			car.attemptMoving();
		}
	}

	public List<Car> getCarList() {
		return carList;
	}
}
