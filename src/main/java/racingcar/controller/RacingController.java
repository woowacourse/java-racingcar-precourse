package racingcar.controller;

import java.util.ArrayList;
import java.util.List;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.service.InputService;
import racingcar.service.OutputService;
import racingcar.service.RacingService;
import racingcar.view.OutputView;

public class RacingController {
	private static int tryNumber;

	public static void initialize() {
		List<String> carNames = InputService.getCarNames();
		Cars cars = getCarsFromNames(carNames);
		tryNumber = InputService.getTryNumber();
		startRacing(cars);
	}

	public static void startRacing(Cars cars) {
		OutputView.printRacingResult();
		for (int i = 0; i < tryNumber; i++) {
			RacingService.playOneRound(cars.getCars());
		}
		endRacing(cars);
	}

	public static Cars getCarsFromNames(List<String> carNames) {
		List<Car> cars = new ArrayList<>();
		for (String name : carNames) {
			cars.add(new Car(name));
		}
		return new Cars(cars);
	}

	public static void endRacing(Cars cars) {
		List<String> winner = RacingService.getWinner(cars.getCars());
		OutputService.getWinnerNameList(winner);
	}
}