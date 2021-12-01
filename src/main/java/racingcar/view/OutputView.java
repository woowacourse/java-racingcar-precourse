package racingcar.view;

import static racingcar.constant.GameConstants.*;

public class OutputView {
	public static void printErrorMessage(String errorMessage) {
		System.out.println(errorMessage);
	}

	public static void printAskingCarNames() {
		System.out.println(String.format(ASK_CAR_NAMES, CAR_NAME_DELIMITER));
	}
}
