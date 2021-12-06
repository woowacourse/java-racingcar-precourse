package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.print.attribute.IntegerSyntax;

import utils.RandomNumberGenerator;

public class RacingCars {
	private static final int FIRST_CAR = 0;
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
		int lastCar = cars.size();
		for (int index = FIRST_CAR; index < lastCar; index++) {
			cars.get(index).moveCar(RandomNumberGenerator.makeRandomNumber());
		}
	}

	public String[] bringCarNames() {
		return cars.stream().map(car -> car.getName()).toArray(String[]::new);
	}

	public int[] bringCarPositions() {
		return cars.stream().mapToInt(car -> car.getPosition()).toArray();
	}
}
