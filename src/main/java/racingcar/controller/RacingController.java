package racingcar.controller;

import racingcar.view.InputView;

public class RacingController {

	public static String[] InitializeCarNames() {
		return InputView.scanCarNames().split(",");
	}
}
