package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class RacingCars {
	private final ArrayList<Car> cars = new ArrayList<>();

	public RacingCars(ArrayList<String> cars) {
		for (String car : cars) {
			this.cars.add(new Car(car));
		}
	}

	public ArrayList<Car> getRoundResult() {
		for (Car car : cars) {
			car.go();
		}
		return cars;
	}

	public String[] getWinners() {
		int maxPosition = findMax(getPositions());
		return cars
			.stream()
			.filter(car -> car.getPosition() == maxPosition)
			.map(Car::getName)
			.toArray(String[]::new);
	}

	public ArrayList<Integer> getPositions() {
		ArrayList<Integer> positions = new ArrayList<>();
		for (Car car : cars) {
			positions.add(car.getPosition());
		}
		return positions;
	}

	public static int findMax(ArrayList<Integer> positions) {
		return Collections.max(positions);
	}
}
