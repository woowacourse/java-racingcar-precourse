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

	public void roundGo() {
		for (Car car : cars) {
			car.go();
		}
	}

	public HashMap<String, Integer> getRoundResult() {
		HashMap<String, Integer> roundResult = new HashMap<>();
		for (Car car : cars) {
			roundResult.put(car.getName(), car.getPosition());
		}
		return roundResult;
	}

	public String[] getWinners() {
		int maxPosition = findMax(getPositions());
		return (String[])cars
			.stream()
			.map(car -> car.getPosition() == maxPosition)
			.toArray();
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
