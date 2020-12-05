package racingcar;

import java.util.Scanner;

import utils.InputManager;

public class Application {
	public static void main(String[] args) {
		final Scanner scanner = new Scanner(System.in);

		InputManager inputManager = new InputManager(scanner);

		String[] carNames = inputManager.getCarNamesFromInput();
		int roundNumber = inputManager.getRoundNumberFromInput();

		Racing racing = new Racing(carNames);
		
		racing.start(roundNumber);
		racing.printWinner();
	}
}
