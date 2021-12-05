package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

	public void run() {
		Cars cars = inputCars();
	}

	private Cars inputCars() {
		while (true) {
			try {
				OutputView.printInputCarName();
				return createCars(InputView.inputCarNames());
			} catch (IllegalArgumentException exception) {
				OutputView.printException(exception);
				return inputCars();
			}
		}
	}

	private Cars createCars(String[] inputCarNames) {
		List<Car> cars = Arrays.stream(inputCarNames)
			.map(Car::new)
			.collect(Collectors.toList());
		return new Cars(cars);
	}
}
