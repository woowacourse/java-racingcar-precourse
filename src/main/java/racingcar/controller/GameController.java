package racingcar.controller;

import java.util.ArrayList;

import racingcar.model.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
	private final InputView input;
	private final OutputView output;
	private final ArrayList<String> champion;
	private int highScore;

	public GameController() {
		input = new InputView();
		output = new OutputView();
		champion = new ArrayList<>();
	}

	public void start() {
		String[] carNames = input.carNames();
		Car[] cars = createCars(carNames);

		String round = input.round();
		output.printRoundResult(round, cars);

		getHighScore(cars);
		getChampionList(cars, highScore);
		output.printChampionList(champion);
	}

	private Car[] createCars(String[] carNames) {
		Car[] cars = new Car[carNames.length];
		for (int i = 0; i < carNames.length; i++) {
			cars[i] = new Car(carNames[i]);
		}
		return cars;
	}

	private void getHighScore(Car[] cars) {
		for (Car car : cars) {
			highScore = car.updateHighScore(highScore);
		}
	}

	private void getChampionList(Car[] cars, int highScore) {
		for (Car car : cars) {
			car.isChampion(champion, highScore);
		}
	}
}
