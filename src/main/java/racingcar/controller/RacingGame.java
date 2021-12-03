package racingcar.controller;

import static racingcar.view.InputView.*;
import static racingcar.view.OutputView.*;


import java.util.List;

import racingcar.domain.Car;
import racingcar.domain.RandomNumber;

public class RacingGame {

	public void run() {
		printCarNameInputMessage();
		Car[] carName = createCarInstance(inputCarName());
		printAttemptInputMessage();
		int attemptNumber = inputAttemptNumber();
		printExecutionResult();
		for (int i = 0; i < attemptNumber; i++) {
			System.out.println(i + "번째 시도");
			makeCarMove(carName);
		}
	}

	public static Car[] createCarInstance(List<String> carNameList) {
		Car[] carName = new Car[carNameList.size()];
		for (int i = 0; i < carNameList.size(); i++) {
			carName[i] = new Car(carNameList.get(i));
		}
		return carName;
	}

	public static void makeCarMove(Car[] carName) {
		for (Car car : carName) {
			if (createRandomNumberForCarMovement()) {
				car.moveForward();
				System.out.println(car.getName()+": " + car.getPosition() + "이동");
			}
		}
	}

	public static boolean createRandomNumberForCarMovement() {
		int randomNumber = RandomNumber.pickRandomNumber();
		if (randomNumber >= 4) {
			return true;
		}
		return false;
	}

}
