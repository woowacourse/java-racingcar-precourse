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
	}

	public boolean isEndGame() {
		return false;
	}
}
