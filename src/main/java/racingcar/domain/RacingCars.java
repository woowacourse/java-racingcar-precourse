package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
	private final List<Car> racingCars;

	public RacingCars(List<Car> racingCars) {
		this.racingCars = racingCars;
	}

	public void moveRacingCars() {
		for (Car car : racingCars) {
			car.moveCar();
		}
	}

	public List<Car> getRacingCars() {
		return racingCars;
	}

	public Integer getMaxDistance() {
		int maxDistance = Integer.MIN_VALUE;
		for (Car car : racingCars) {
			maxDistance = Math.max(maxDistance, car.getPosition());
		}
		return maxDistance;
	}

	public List<String> getWinnerNames(Integer maxDistance) {
		List<String> tmpWinnerCarNames = new ArrayList<>();
		for (Car car : racingCars) {
			if (car.isWinner(maxDistance)) {
				tmpWinnerCarNames.add(car.getName());
			}
		}
		return tmpWinnerCarNames;
	}
}
