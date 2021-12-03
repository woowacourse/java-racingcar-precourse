package racingcar.game;

import java.util.ArrayList;
import java.util.List;

import racingcar.car.Car;

public class RacingGame {
	private List<Car> cars;
	private Movement movement;

	public RacingGame(List<Car> cars) {
		this.cars = cars;
		this.movement = new Movement();
	}

	public List<String> race() {
		List<String> racingResult = new ArrayList<>();
		for (Car each : cars) {
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

	public String getWinners() {
		Winners winners = new Winners(cars);
		return winners.getWinnersMessage();
	}
}
