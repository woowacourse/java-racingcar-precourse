package racingcar.controller;

import java.util.ArrayList;
import java.util.List;

import racingcar.domain.Car;
import racingcar.domain.RacingCars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
	private RacingCars racingCars;
	private Integer gameCount;
	private String[] carNames;

	public void start() {
		getInputCars();
		makeRacingCars(carNames);
		getInputGameCount();
		moveCars();
		confirmWinner();
	}

	private void getInputCars() {
		carNames = InputView.inputCarName();
	}

	private void makeRacingCars(String[] carNames) {
		List<Car> tmpRacingCar = new ArrayList<>();
		for (String carName : carNames) {
			Car tmpCar = new Car(carName);
			tmpRacingCar.add(tmpCar);
		}
		racingCars = new RacingCars(tmpRacingCar);
	}

	private void getInputGameCount() {
		gameCount = InputView.inputGameCount();
	}

	private void moveCars() {
		OutputView.printExecutionMessage();
		for (int cnt = 0; cnt < gameCount; cnt++) {
			racingCars.moveRacingCars();
			for (Car car : racingCars.getRacingCars()) {
				OutputView.printCarName(car.getName());
				OutputView.printCarPosition(car.getPosition());
			}
			OutputView.printNewLine();
		}
	}

	private void confirmWinner() {
		int maxDistance = racingCars.getMaxDistance();
		OutputView.printWinner(racingCars.getWinnerNames(maxDistance));
	}
}
