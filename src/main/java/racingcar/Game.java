package racingcar;

import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constant.Message;
import racingcar.iomanagement.InputScanner;
import racingcar.iomanagement.OutputPrinter;

public class Game {
	CarManager carManager = new CarManager();
	InputScanner inputScanner = new InputScanner();
	OutputPrinter outputPrinter = new OutputPrinter();

	public void startGame() {
		String  carNames = inputScanner.enterCarName();
		List<Car> carList = carManager.generate(carNames);
		long count = inputScanner.enterCount();

		System.out.println(Message.EXECUTION_RESULT);
		carList = getResultOfEachAttempt(carList, count);

		List<Car> winnerCarList = carManager.getWinner(carList);
		outputPrinter.printFinalWinner(winnerCarList);
	}

	public List<Car> getResultOfEachAttempt(List<Car> carList, long count) {
		for (int i = 0; i < count; i++) {
			carList = carManager.updateCarListPosition(carList);
			carList.forEach(car -> outputPrinter.printStepResult(car));
			System.out.println();
		}
		return carList;
	}
}
