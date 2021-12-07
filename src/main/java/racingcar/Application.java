package racingcar;

import racingcar.domain.CarList;
import racingcar.domain.Winner;
import racingcar.input.InputController;

public class Application {

	private static int trial;
	private static CarList carList;

	public static void main(String[] args) {
		// TODO 구현 진행
		setCarNameAndTrial();
		playGame();
		printResult();
	}

	private static void printResult() {
		carList.setWinner();
		Winner.print();
	}

	private static void playGame() {
		System.out.println("실행 결과");
		while (--trial >= 0) {
			CarList.iteratePerCar();
		}
	}

	private static void setCarNameAndTrial() {
		carList = new CarList(InputController.getCarNameInput());
		trial = InputController.getTrialInput();
	}
}
