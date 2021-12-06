package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import utils.RandomNumberGenerator;

public class RacingCars {
	private List<Car> cars = new ArrayList<>();

	public RacingCars(String[] carNames) {
		makeCars(carNames);
	}

	private void makeCars(String[] carNames) {
		cars = Arrays.stream(carNames).
			map(car -> new Car(car)).
			collect(Collectors.toList());
	}

	public void moveCars() {
		for (int index = 0; index < cars.size(); index++) {
			cars.get(index).moveCar(RandomNumberGenerator.makeRandomNumber());
		}
	}

	public String[] findCarNames() {
		return cars.stream().map(car -> car.getName()).toArray(String[]::new);
	}

	public int[] findCarPositions() {
		return cars.stream().mapToInt(car -> car.getPosition()).toArray();
	}
}
