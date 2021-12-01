package racingcar.car;

import java.util.ArrayList;

public class CarRepository {
	private ArrayList<Car> cars = new ArrayList<>();

	public void addCars(Car car) {
		cars.add(car);
	}

	public ArrayList<Car> getCars() {
		return cars;
	}
}
