package racingcar.game;

import java.util.ArrayList;
import java.util.List;

import racingcar.car.Car;

public class RacingGame {
	private static final int ZERO = 0;

	private List<Car> carList;
	private Movement movement;

	public RacingGame(List<Car> carList) {
		this.carList = carList;
		this.movement = new Movement();
	}

	public List<String> race() {
		List<String> racingResult = new ArrayList<>();
		for (Car each : carList) {
			moveCar(each);
			addResult(racingResult, each);
		}
		return racingResult;
	}

	private void moveCar(Car car) {
		if (movement.isMovableForward()) {
			car.moveForward();
		}
	}

	private void addResult(List<String> racingResult, Car car) {
		racingResult.add(car.positionToString());
	}

	public List<String> findFrontCars() {
		List<String> frontCarsName = new ArrayList<>();
		int maxDistance = getMaxDistance();
		for (Car each : carList) {
			insertCarName(frontCarsName, each, maxDistance);
		}
		return frontCarsName;
	}

	private int getMaxDistance() {
		int maxDistance = ZERO;
		for (Car each : carList) {
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
