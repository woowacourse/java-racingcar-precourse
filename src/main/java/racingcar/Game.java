package racingcar;

import racingcar.domain.Cars;
import racingcar.handler.InputHandler;
import racingcar.handler.PrintHandler;
import racingcar.utils.Validator;

public class Game {
	private Cars cars;
	private int runNumber;

	public void run() {
		inputName();
		inputRunNumber();
		PrintHandler.printResultMsg();
		for (int i = 0; i < runNumber; i++) {
			playOnce();
		}
		cars.getWinner();
	}

	private void inputName() {
		PrintHandler.printInputNameMsg();
		String[] names;
		do {
			names = InputHandler.getNameInput();
		} while (!validateNames(names));
		createCars(names);
	}

	private void createCars(String[] names) {
		cars = new Cars(names);
	}

	private void inputRunNumber() {
		PrintHandler.printInputNumberMsg();
		String input;
		do {
			input = InputHandler.getNumberInput();
		} while (!validateRunNumber(input));
		runNumber = Integer.parseInt(input);
	}

	private boolean validateNames(String[] names) {
		try {
			Validator.validateNameInput(names);
			return true;
		} catch (IllegalArgumentException e) {
			PrintHandler.printErrorMsg(e);
			return false;
		}
	}

	private boolean validateRunNumber(String input) {
		try {
			Validator.validateNumberInput(input);
			return true;
		} catch (IllegalArgumentException e) {
			PrintHandler.printErrorMsg(e);
			return false;
		}
	}

	private void playOnce() {
		cars.playOnce();
		PrintHandler.printBlank();
	}
}
