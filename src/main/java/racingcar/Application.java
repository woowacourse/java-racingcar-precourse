package racingcar;

import java.util.List;

import racingcar.domain.Car;
import racingcar.input.InputController;

public class Application {

	private static List<Car> cars;
	private static int trial;

	public static void main(String[] args) {
		// TODO 구현 진행
		setInputData();
		playGame();
	}

	private static void playGame() {
		System.out.println("실행 결과");
		while (--trial >= 0) {
			iteratePerCar();
		}
	}

	private static void iteratePerCar() {
		for (Car car : cars) {
			car.moveOrStop();
			car.printPosition();
		}
		System.out.println();
	}

	private static void setInputData() {
		cars = InputController.getCarNameInput();
		trial = InputController.getTrialInput();
	}
}
