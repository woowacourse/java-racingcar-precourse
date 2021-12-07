package racingcar;

import java.util.List;

import racingcar.constant.Message;
import racingcar.constant.Number;
import racingcar.iomanagement.InputScanner;
import racingcar.iomanagement.OutputPrinter;

public class Game {
	CarManager carManager = new CarManager();
	InputScanner inputScanner = new InputScanner();
	OutputPrinter outputPrinter = new OutputPrinter();

	public void start() {
		List<Car> carList = carManager.generateWithException();
		long count = Long.parseLong(inputScanner.enterCountWithException());

		System.out.println(Message.EXECUTION_RESULT);
		carList = getResultOfEachAttempt(carList, count);

		List<Car> winnerCarList = carManager.getWinner(carList);
		outputPrinter.printFinalWinner(winnerCarList);
	}

	public List<Car> getResultOfEachAttempt(List<Car> carList, long count) {
		for (int i = Number.ZERO; i < count; i++) {
			carList = carManager.updateCarListPosition(carList);
			carList.forEach(car -> outputPrinter.printStepResult(car));
			System.out.println();
		}
		return carList;
	}
}
