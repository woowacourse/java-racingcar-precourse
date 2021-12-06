package racingcar.controller;

import static racingcar.service.InputService.*;

import java.util.ArrayList;
import java.util.List;

import racingcar.Car;
import racingcar.domain.Cars;
import racingcar.service.InputService;
import racingcar.service.RacingService;

public class RacingController {
	private static int tryNumber;

	public static void initialize() {
		String[] carNames = InputService.getCarNames();
		Cars cars = getCarsFromNames(carNames);
		tryNumber = InputService.getTryNumber();
		startRacing(cars);
	}

	public static void startRacing(Cars cars) {
		for (int i = 0; i < tryNumber; i++) {
			RacingService.playOneRound(cars.getCars());
		}
	}

	public static Cars getCarsFromNames(String[] carNames) {
		List<Car> cars = new ArrayList<>();
		for (String name : carNames) {
			cars.add(new Car(name));
		}
		return new Cars(cars);
	}
}