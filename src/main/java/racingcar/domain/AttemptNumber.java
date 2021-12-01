package racingcar.domain;

import static racingcar.util.AttemptNumberValidator.*;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class AttemptNumber {
	private int number;

	public AttemptNumber() {
		number = setNumber();
	}

	private int setNumber() {
		String number;
		do {
			OutputView.printAskingAttemptNumber();
			number = InputView.getInput();
		} while (!isValidAttemptNumber(number));
		return Integer.parseInt(number);
	}
}
