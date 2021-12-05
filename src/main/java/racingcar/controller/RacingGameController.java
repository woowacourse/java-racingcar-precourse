package racingcar.controller;

import java.util.List;

import racingcar.model.CarModel;
import racingcar.view.RacingGameInputView;
import racingcar.view.RacingGameOutputView;

public class RacingGameController {
	private final RacingGameInputView racingGameInputView;
	private final RacingGameOutputView racingGameOutputView;
	private final CarModel carModel;
	private int repetitionNumber;

	public RacingGameController() {
		racingGameInputView = RacingGameInputView.getRacingGameInputView();
		racingGameOutputView = RacingGameOutputView.getRacingGameOutputView();
		carModel = CarModel.getCarModel();
	}

	public void startGame() {
		takeCarList();
		takeRepetitionNumber();
		racingGameOutputView.printMovementStart();
		for (int i = 0; i < repetitionNumber; i++) {
			carModel.moveAllCars();
			List<String> visualizedPositions = carModel.getVisualizedPositions();
			List<String> carNames = carModel.getCarNames();
			racingGameOutputView.printMovement(visualizedPositions, carNames);
		}
		racingGameOutputView.printWinners(carModel.getWinners());
	}

	private void takeRepetitionNumber() {
		repetitionNumber = racingGameInputView.getRepetitionNumber();
	}

	private void takeCarList() {
		List<String> carNames = racingGameInputView.getCarNames();
		carModel.createCars(carNames);
	}
}
