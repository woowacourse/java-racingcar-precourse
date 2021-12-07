package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.view.OutputView;

public class GameController {

	public void play() {
		InputController game = new InputController();
		Cars carList = game.getInput_Car();
		int tryNum = game.getInput_try();
		OutputView.printRacingStart();
		roundPlay(carList, tryNum);
	}

	public void roundPlay(Cars carList, int tryNum) {
		for (int i = 0; i < tryNum; i++) {
			carList.raceCars();
		}
		OutputView.printWinner(carList.findWinners());
	}

}
