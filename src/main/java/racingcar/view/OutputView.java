package racingcar.view;

import static racingcar.constant.GameConstants.*;

public class OutputView {
	public static void printErrorMessage(String errorMessage) {
		System.out.println(errorMessage);
	}

	public static void printAskingCarNames() {
		System.out.println(ASK_CAR_NAMES_MESSAGE);
	}

	public static void printAskingAttemptNumber() {
		System.out.println(ASK_ATTEMPT_NUMBER_MESSAGE);
	}
}
