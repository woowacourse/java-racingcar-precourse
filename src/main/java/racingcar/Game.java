package racingcar;

import static racingcar.InputReader.*;
import static racingcar.MessagePrinter.*;

import java.util.ArrayList;

public class Game {

	private Car[] cars;
	private int numberOfCars;
	private int numberOfRepetitions;

	public void init() {
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

		ArrayList<String> winnerList = createWinnerList();
		printWinners(winnerList);
	}

	private void proceedTurn() {
		for (Car car : cars) {
			car.moveOrStay();
		}
	}

	private ArrayList<String> createWinnerList() {
		int winnerPosition = getWinnerPosition();

		ArrayList<String> winnerList = new ArrayList<>();
		for (Car car : cars) {
			if (winnerPosition == car.getPosition()) {
				winnerList.add(car.getName());
			}
		}

		return winnerList;
	}

	private int getWinnerPosition() {
		int winnerPosition = -1;
		for (Car car : cars) {
			winnerPosition = Math.max(winnerPosition, car.getPosition());
		}

		return winnerPosition;
	}

}
