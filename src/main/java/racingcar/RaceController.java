package racingcar;

import java.util.ArrayList;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {
	private InputView inputView;
	private OutputView outputView;
	private CarService carService;

	public RaceController() {
		inputView = new InputView();
		outputView = new OutputView();
		carService = new CarService();
	}

	public void start() {
		ArrayList<String> names = getProperNames();
		Car[] cars = carService.enrollCars(names);
		int moveCount = getProperMoveCount();
		startRace(cars, moveCount);
		ArrayList<String> winners = carService.findWinners(cars);
		showWinners(winners);
	}

	private ArrayList<String> getProperNames() {
		ArrayList<String> properNames = inputView.getProperNameList();
		return properNames;
	}

	private int getProperMoveCount() {
		int moveCount = inputView.getProperMoveCount();
		return moveCount;
	}

	private void startRace(Car[] cars, int moveCount) {
		outputView.printExecutionResult();
		for (int i = 0; i < moveCount; i++) {
			carService.startEachRace(cars);
		}
	}

	private void showWinners(ArrayList<String> winners) {
		outputView.printWinners(winners);
	}
}
