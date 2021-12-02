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

}
