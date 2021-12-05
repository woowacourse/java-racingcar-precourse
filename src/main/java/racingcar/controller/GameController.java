package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

	public void run() {
		Cars cars = inputCars();
		int gameRound = inputGameRound();
		RacingGame racingGame = new RacingGame(cars, gameRound);
		while (!racingGame.isFinish()) {
			racingGame.race();
			OutputView.printRaceProgress(cars);
		}
		OutputView.printRaceResult(racingGame.findWinner());
	}

	private Cars inputCars() {
		try {
			OutputView.printInputCarName();
			return createCars(InputView.inputCarNames());
		} catch (IllegalArgumentException exception) {
			OutputView.printException(exception);
			return inputCars();
		}
	}

	private Cars createCars(String[] inputCarNames) {
		List<Car> cars = Arrays.stream(inputCarNames)
			.map(Car::new)
			.collect(Collectors.toList());
		return new Cars(cars);
	}

	private int inputGameRound() {
		try {
			OutputView.printInputGameRound();
			return InputView.inputGameRound();
		} catch (IllegalArgumentException exception) {
			OutputView.printException(exception);
			return inputGameRound();
		}
	}
}
