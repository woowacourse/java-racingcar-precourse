package racingcar.domain;

import static racingcar.util.AttemptNumberValidator.*;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class AttemptNumber {
	private int attemptNumber;
	private static int numberOfRuns = 0;

	public AttemptNumber() {
		attemptNumber = setAttemptNumber();
	}

	private int setAttemptNumber() {
		String attemptNumber;
		do {
			OutputView.printAskingAttemptNumber();
			attemptNumber = InputView.getInput();
		} while (!isValidAttemptNumber(attemptNumber));
		return Integer.parseInt(attemptNumber);
	}

	public boolean isAttemptRemained() {
		boolean result = (attemptNumber != numberOfRuns);
		numberOfRuns++;
		return result;
	}
}
