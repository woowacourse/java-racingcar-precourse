package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class GameManager {
	public InputManager inputManager;
	public int[] carsMoveCount;

	public GameManager(InputManager inputManager) {
		this.inputManager = inputManager;
	}

	public void startGame() {
		inputManager.scanCars();
		inputManager.scanNumber();
		carsMoveCount = new int[inputManager.carsList.length];
		for (int i = 0; i < inputManager.numberOfMove; i++) {
			playRound();
		}
	}

	public void playRound() {
		for (int i = 0; i < carsMoveCount.length; i++) {
			if (calculateMove()) {
				carsMoveCount[i]++;
			}
		}
	}

	public boolean calculateMove() {
		int randomNumber = Randoms.pickNumberInRange(0, 9);
		if (randomNumber >= 4) {
			return true;
		}
		return false;
	}
}
