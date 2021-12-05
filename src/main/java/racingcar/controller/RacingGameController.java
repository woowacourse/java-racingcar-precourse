package racingcar.controller;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.Car;
import racingcar.view.RacingGameInputView;
import racingcar.view.RacingGameOutputView;

public class RacingGameController {
	private final RacingGameInputView racingGameInputView;
	private final RacingGameOutputView racingGameOutputView;
	private List<Car> carList;
	private int repetitionNumber;

	public RacingGameController() {
		racingGameInputView = RacingGameInputView.getRacingGameInputView();
		racingGameOutputView = RacingGameOutputView.getRacingGameOutputView();
	}

	public void startGame() {
		takeCarList();
		takeRepetitionNumber();
		racingGameOutputView.printMovementStart();
		for (int i = 0; i < repetitionNumber; i++) {
			carList.forEach(Car::tryMoving);
			racingGameOutputView.printMovement(carList);
		}
		racingGameOutputView.printWinners(getWinners());
	}

	private void takeRepetitionNumber() {
		repetitionNumber = racingGameInputView.getRepetitionNumber();
	}

	private void takeCarList() {
		carList =
			racingGameInputView.getCarNames()
				.stream()
				.map(Car::new)
				.collect(Collectors.toList());
	}

	private List<String> getWinners() {
		int maxPosition = carList.stream()
			.mapToInt(Car::getPosition)
			.max()
			.orElse(0);

		return carList.stream()
			.filter(car -> car.getPosition() == maxPosition)
			.map(Car::getName)
			.collect(Collectors.toList());
	}
}
