package racingcar.model;

import static racingcar.model.Util.findMax;

import java.util.ArrayList;

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
		int winPosition = findMax(getPositions());
		return cars
			.stream()
			.filter(car -> car.isWinner(winPosition))
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
}
