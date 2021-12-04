package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Cars;
import racingcar.handler.InputHandler;
import racingcar.handler.PrintHandler;
import racingcar.utils.Validator;

public class Game {
	private static final int RANGE_MIN_VALUE = 0;
	private static final int RANGE_MAX_VALUE = 9;

	private Cars cars;
	private int runNumber;
	private int carsSize;

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
		carsSize = cars.size();
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
		cars.playOnce(generateRandomNumbers());
		PrintHandler.printBlank();
	}

	private int[] generateRandomNumbers() {
		int[] randomNumbers = new int[carsSize];
		for (int i = 0; i < carsSize; i++) {
			randomNumbers[i] = Randoms.pickNumberInRange(RANGE_MIN_VALUE, RANGE_MAX_VALUE);
		}
		return randomNumbers;
	}
}
