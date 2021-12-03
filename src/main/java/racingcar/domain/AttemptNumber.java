package racingcar.domain;

import static racingcar.util.AttemptNumberValidator.*;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class AttemptNumber {
	private static int numberOfRuns = 0;
	private final int attemptNumber;

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
