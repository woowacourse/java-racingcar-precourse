package racingcar.controller;

import racingcar.view.InputView;

public class RacingController {

	public static String[] InitializeCarNames() {
		return InputView.scanCarNames().split(",");
	}

	public static int InitializeTryNumber() {
		String tryNumber = InputView.scanTryNumber();
		return Integer.parseInt(tryNumber);
	}
}
