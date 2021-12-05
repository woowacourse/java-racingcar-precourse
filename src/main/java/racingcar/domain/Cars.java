package racingcar.domain;

import java.util.LinkedList;
import java.util.List;

public class Cars {
	private List<Car> cars = new LinkedList<>();

	public Cars(String[] names) {
		for (String name : names) {
			cars.add(new Car(name));
		}
	}

	public void racing() {
		cars.forEach(car -> {
			car.moveForward();
			car.printState();
		});
		System.out.println();
	}
}
