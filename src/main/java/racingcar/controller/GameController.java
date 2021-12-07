package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.view.OutputView;

public class GameController {

	public void play() {

	}

	public void roundPlay(Cars carList, int tryNum) {
		for (int i = 0; i < tryNum; i++) {
			carList.raceCars();
		}
		OutputView.printWinner(carList.findWinners());
	}

}
