package racingcar.controller;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.Car;
import racingcar.view.RacingGameView;

public class RacingGameController {
	private final RacingGameView racingGameView;
	private List<Car> carList;

	public RacingGameController() {
		racingGameView = RacingGameView.getRacingGameView();
	}

	public void startGame() {
		int repetitionNumber;
		takeCarList();
		repetitionNumber = racingGameView.getRepetitionNumber();
		racingGameView.printMovementStart();
		for (int i = 0; i < repetitionNumber; i++) {
			carList.forEach(Car::tryMoving);
			racingGameView.printMovement(carList);
		}
		racingGameView.printWinners(getWinners());
	}

	private void takeCarList() {
		carList =
			racingGameView.getCarNames()
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
