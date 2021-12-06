package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Winner {

	static final int INITIAL_MAX_POSITION = 0;

	List<String> winner = new ArrayList<>();

	public List<String> findWinner(List<Car> racingCars) {
		int maxPosition = findMaxPosition(racingCars);
		for (Car car : racingCars) {
			if (car.getPosition() == maxPosition) {
				winner.add(car.getName());
			}
		}
		return winner;
	}

	private int findMaxPosition(List<Car> racingCars) {
		int maxPosition = INITIAL_MAX_POSITION;
		for (Car car : racingCars) {
			if (car.getPosition() > maxPosition) {
				maxPosition = car.getPosition();
			}
		}
		return maxPosition;
	}
}
