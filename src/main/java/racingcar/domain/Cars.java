package racingcar.domain;

import java.util.Collections;
import java.util.List;

public class Cars {
	List<Car> cars;

	public Cars(List<Car> cars) {
		this.cars = cars;
	}

	public List<Car> getCars() {
		return Collections.unmodifiableList(cars);
	}

	public void move() {
		cars.forEach(car -> car.move(new RandomMovingStrategy()));
	}

	public void printPosition() {
		cars.forEach(car -> car.printPosition());
		System.out.println();
	}

	public boolean isEndGame(int tryNumber) {
		return cars.stream()
			.anyMatch(car -> car.isEndGame(tryNumber));
	}
}
