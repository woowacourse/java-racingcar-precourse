package racingcar;

import static racingcar.InputReader.*;
import static racingcar.MessagePrinter.*;

public class Game {

	private final Car[] cars;
	private final int numberOfCars;
	private final int numberOfRepetitions;

	public Game() {
		askCarNameList();
		String[] nameList = returnCarNameList();
		numberOfCars = nameList.length;
		cars = new Car[numberOfCars];

		for (int i = 0; i < numberOfCars; i++) {
			cars[i] = new Car(nameList[i]);
		}

		askForRepetitions();
		numberOfRepetitions = returnNumberOfRepetitions();
	}

	public void play() {
		printStartMessage();

		int turnCount = 0;
		while (turnCount++ < numberOfRepetitions) {
			proceedTurn();
			printTurnResult(cars);
		}
	}

	private void proceedTurn() {
		for (Car car : cars) {
			car.moveOrStay();
		}
	}

	private int getWinnerPosition() {
		int winnerPosition = -1;
		for (Car car : cars) {
			winnerPosition = Math.max(winnerPosition, car.getPosition());
		}

		return winnerPosition;
	}

}
