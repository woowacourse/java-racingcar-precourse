package racingcar;

import java.util.ArrayList;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {
	private InputView inputView;
	private OutputView outputView;
	private Cars cars;

	public RaceController() {
		inputView = new InputView();
		outputView = new OutputView();
		cars = new Cars();
	}

	public void start() {
		ArrayList<String> names = getProperNames();
		cars.enrollCars(names);
		int moveCount = getProperMoveCount();
		startRace(cars, moveCount);
		ArrayList<String> winners = cars.findWinners();
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

	private void startRace(Cars cars, int moveCount) {
		outputView.printExecutionResult();
		for (int i = 0; i < moveCount; i++) {
			cars.startEachRace();
		}
	}

	private void showWinners(ArrayList<String> winners) {
		outputView.printWinners(winners);
	}
}
