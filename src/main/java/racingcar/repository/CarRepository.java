package racingcar.repository;

import java.util.ArrayList;

import racingcar.domain.Car;

public class CarRepository {

	private static final ArrayList<Car> carList = new ArrayList<>();

	public static void addCar(String name) {
		carList.add(new Car(name));
	}

	public static ArrayList<Car> getCarList() {
		return carList;
	}
}
