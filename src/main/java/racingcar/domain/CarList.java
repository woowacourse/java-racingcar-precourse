package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarList {
	private final List<Car> list;

	public CarList(String[] names) {
		list = new ArrayList<Car>();
		createCars(names);
	}

	public void playOnce() {
		list.forEach(Car::playOnce);
	}

	private void createCars(String[] names) {
		Arrays.stream(names).forEach(name -> {
			Car car = new Car(name.trim());
			list.add(car);
		});
	}
}
