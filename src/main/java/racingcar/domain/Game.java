package racingcar.domain;

import static racingcar.view.InputView.*;

import java.util.List;

import racingcar.ValidationUtils;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Game {
	public int gameCount;
	public Cars carList;

	public static void runGameByCar(Car drivingCar) {
		int randomNo = new GenerateRandomNo().randomNo;
		if (Car.isForward(randomNo)) {
			drivingCar.forward();
		}
		System.out.println(drivingCar.getName() + " : " + drivingCar.getScoreString());
	}

	public static void runGameOneStep(Cars carList) {
		for (Car car : carList.getCars()) {
			runGameByCar(car);
		}
		System.out.println();
	}

	public void runGame() {
		Game newGame = new Game();
		newGame.generateCars();
		newGame.getGameCount();
		OutputView.printResultMessage();
		for (int i = 0; i < newGame.gameCount; i++) {
			runGameOneStep(newGame.carList);
		}
		this.carList = newGame.carList;
	}

	public void generateCars() {
		List<String> userInput;
		do {
			InputView.printStartMessage();
			userInput = strToList(generateUserInput());
		} while (!ValidationUtils.validCarList(userInput));
		Cars carList;
		carList = new Cars(userInput);

		this.carList = carList;
	}

	public void getGameCount() {
		String input;
		do {
			InputView.printGetCountMessage();
			input = generateUserInput();
		} while (!ValidationUtils.validNumber(input));
		this.gameCount = Integer.parseInt(input);
	}
}
