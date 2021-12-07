package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class CarList {

	private static List<Car> cars;

	public CarList(List<String> carNames) {
		cars = new ArrayList<>();
		for (String name : carNames) {
			cars.add(new Car(name));
		}
	}

	public static void iteratePerCar() {
		for (Car car : cars) {
			car.moveOrStop();
			car.printPosition();
		}
		System.out.println();
	}

	public void setWinner() {
		for (Car car : cars) {
			addIfWinner(car);
		}
	}

	private void addIfWinner(Car car) {
		if (car.isWinner()) {
			car.joinWinner();
		}
	}
}
