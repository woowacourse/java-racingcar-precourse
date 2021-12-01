package racingcar.controller;

import static constants.RacingCarConstant.*;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.domain.RacingCar;
import racingcar.validator.CarNameValidator;
import racingcar.validator.GameCountValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
	private RacingCar racingCar;
	private Integer gameCount;

	public void start() {
		getInputCars();
		getInputGameCount();
	}

	private void getInputCars() {
		InputView.printCarNameInputMessage();
		String carNameInput = Console.readLine();
		try {
			CarNameValidator.checkCarNameInput(carNameInput);
			String[] tmpCarNames = carNameInput.split(DELIMITER);
			CarNameValidator.checkCarNames(tmpCarNames);
			makeCars(tmpCarNames);
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			getInputCars();
		}
	}

	private void makeCars(String[] tmpCarNames) {
		List<Car> tmpRacingCar = new ArrayList<>();
		for (String tmpCarName : tmpCarNames) {
			Car tmpCar = new Car(tmpCarName);
			tmpRacingCar.add(tmpCar);
		}
		racingCar = new RacingCar(tmpRacingCar);
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
}
