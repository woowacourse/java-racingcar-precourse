package racingcar.model;

import static racingcar.model.Util.findMax;

import java.util.ArrayList;

public class RacingCars {
	private final ArrayList<Car> CARS = new ArrayList<>();

	public RacingCars(ArrayList<String> cars) {
		for (String car : cars) {
			CARS.add(new Car(car));
		}
	}

	public ArrayList<Car> getRoundResult() {
		for (Car car : CARS) {
			car.go();
		}
		return CARS;
	}

	public String[] getWinners() {
		int winPosition = findMax(getPositions());
		return CARS
			.stream()
			.filter(car -> car.isWinner(winPosition))
			.map(Car::getName)
			.toArray(String[]::new);
	}

	public ArrayList<Integer> getPositions() {
		ArrayList<Integer> positions = new ArrayList<>();
		for (Car car : CARS) {
			positions.add(car.getPosition());
		}
		return positions;
	}
}
