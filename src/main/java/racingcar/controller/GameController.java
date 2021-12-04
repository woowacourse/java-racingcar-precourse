package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;
import racingcar.util.Constants;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
	private static Car[] cars;
	private static int attemptsNum;

	public static void run() {
		checkCars();
		checkAttemptsNum();
		OutputView.showAllProcess(cars, attemptsNum);
		OutputView.showWinner(cars);
	}

	private static void checkCars() {
		try {
			setCars();
		} catch (IllegalArgumentException e) {
			System.out.println(Constants.CAR_NAME_LENGTH_ERROR);
			checkCars();
		}
	}

	private static void setCars() {
		OutputView.askCarNames();
		String input = Console.readLine();
		String[] carNames = InputView.splitString(input);
		cars = createCars(carNames);
	}

	private static Car[] createCars(String[] carNames) {
		Car[] cars = new Car[carNames.length];
		for (int i = 0; i < carNames.length; i++) {
			cars[i] = new Car(carNames[i]);
		}
		return cars;
	}

	private static void checkAttemptsNum() {
		try {
			setAttemptsNum();
		} catch (IllegalArgumentException e) {
			System.out.println(Constants.ATTEMPTS_NUMBER_TYPE_ERROR);
			checkAttemptsNum();
		}
	}

	private static void setAttemptsNum() {
		OutputView.askAttemptsNum();
		String input = Console.readLine();
		attemptsNum = InputView.parseInt(input);
	}
}
