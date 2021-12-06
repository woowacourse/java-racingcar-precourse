package racingcar.service;

import java.util.List;

import racingcar.Car;

public class RacingService {

	public static void playOneRound(List<Car> cars) {
		for (Car car : cars) {
			moveCar(car);
		}
		OutputService.getOneRoundRacingResult(cars);
	}

	public static void moveCar(Car car) {
		if (RandomService.isCarMovable()) {
			car.moveForward();
		}
	}
}
