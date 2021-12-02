package racingcar;

import racingcar.domain.CarList;
import racingcar.handler.InputHandler;
import racingcar.handler.PrintHandler;

public class Game {
	private CarList carList;
	private int runNumber;

	public void run() {
		inputName();
		inputRunNumber();
		PrintHandler.printResultMsg();
		for (int i = 0; i < runNumber; i++) {
			playOnce();
		}
		carList.getWinner();
	}

	private void inputName() {
		PrintHandler.printInputNameMsg();
		try {
			String[] names = InputHandler.getNameInput();
			createCarList(names);
		} catch (IllegalArgumentException e) {
			PrintHandler.printErrorMsg(e);
			inputName();
		}
	}

	private void createCarList(String[] names) {
		carList = new CarList(names);
	}

	private void inputRunNumber() {
		PrintHandler.printInputNumberMsg();
		try {
			this.runNumber = InputHandler.getNumberInput();
		} catch (IllegalArgumentException e) {
			inputRunNumber();
		}
	}

	private void playOnce() {
		carList.playOnce();
		PrintHandler.printBlank();
	}
}
