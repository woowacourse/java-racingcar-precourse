package racingcar.controller;

import racingcar.view.InputView;

public class CarRacingGame {

	public static final String SPLIT_REGEX = ",";

	public static void play() {
		InputView.inputCarsName(SPLIT_REGEX);
		InputView.inputMovesNumber();
	}
}
