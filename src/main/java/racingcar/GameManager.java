package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class GameManager {
	public InputManager inputManager;
	public Car[] cars;

	public GameManager(InputManager inputManager) {
		this.inputManager = inputManager;
	}

	public void startGame() {
		inputManager.scanCars();
		inputManager.scanNumber();
		cars = new Car[inputManager.carsList.length];
		for (int i = 0; i < cars.length; i++) {
			cars[i] = new Car(inputManager.carsList[i]);
		}
		for (int i = 0; i < inputManager.numberOfMove; i++) {
			playRound();
		}
		// for (int i = 0; i < cars.length; i++) {
		// 	System.out.println(cars[i].getName() + " " + cars[i].getPosition());
		// }
	}

	public void playRound() {
		for (int i = 0; i < cars.length; i++) {
			cars[i].addPosition(calculateMove());
		}
	}

	public int calculateMove() {
		int randomNumber = Randoms.pickNumberInRange(0, 9);
		if (randomNumber >= 4) {
			return 1;
		}
		return 0;
	}
}
