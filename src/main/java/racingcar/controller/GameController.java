package racingcar.controller;

import racingcar.utils.InputUtils;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

	public static void controlGame() {
		startGame();
	}

	public static void startGame() {
		OutputView.askCarNames();
		System.out.println(InputUtils.getCarNames(InputView.writeCarNames()));
	}
}
