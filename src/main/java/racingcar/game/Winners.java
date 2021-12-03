package racingcar.game;

import java.util.ArrayList;
import java.util.List;

import racingcar.car.Car;

public class Winners {
	private static final int ZERO = 0;
	private static final String WINNER_FORMAT = "최종 우승자 : ";
	private static final String DELIMITER = ", ";

	private List<Car> cars;

	Winners(List<Car> cars) {
		this.cars = cars;
	}

	public String getWinnersMessage() {
		List<String> winnerCarNames = findFrontCars();
		return WINNER_FORMAT + String.join(DELIMITER, winnerCarNames);
	}

	private List<String> findFrontCars() {
		List<String> frontCarNames = new ArrayList<>();
		int maxDistance = getMaxDistance();
		for (Car each : cars) {
			insertCarName(frontCarNames, each, maxDistance);
		}
		return frontCarNames;
	}

	private int getMaxDistance() {
		int maxDistance = ZERO;
		for (Car each : cars) {
			maxDistance = Math.max(maxDistance, each.getPosition());
		}
		return maxDistance;
	}

	private void insertCarName(List<String> frontCarsName, Car car, int maxDistance) {
		if (car.getPosition() == maxDistance) {
			frontCarsName.add(car.getName());
		}
	}
}
