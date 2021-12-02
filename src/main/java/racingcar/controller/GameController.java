package racingcar.controller;

import racingcar.utils.InputUtils;

public class GameController {

	public static void controlGame() {
		startGame();
	}

	public static void startGame() {
		InputUtils.requestCarNames();
	}
}
