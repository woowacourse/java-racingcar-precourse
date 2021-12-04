package racingcar.controller;

import static constants.RacingCarConstant.*;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.domain.RacingCars;
import racingcar.validator.CarNameValidator;
import racingcar.validator.GameCountValidator;
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
		InputView.printCarNameInputMessage();
		String carNameInput = Console.readLine();
		try {
			CarNameValidator.checkCarNameInput(carNameInput);
			String[] tmpCarNames = carNameInput.split(DELIMITER);
			CarNameValidator.checkCarNames(tmpCarNames);
			carNames = tmpCarNames;
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			getInputCars();
		}
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
		InputView.printCountInputMessage();
		String tmpGameCount = Console.readLine();
		try {
			GameCountValidator.checkGameCount(tmpGameCount);
			gameCount = Integer.parseInt(tmpGameCount);
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			getInputGameCount();
		}
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
