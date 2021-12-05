package racingcar.attempts;

import camp.nextstep.edu.missionutils.Console;
import racingcar.view.ErrorView;
import racingcar.view.InputView;

public class AttemptsController {
	private Attempts attempts;

	public AttemptsController() {
		attempts = new Attempts();
	}

	public Attempts selectAttempts() {
		InputView.showAttemptsMessage();
		requestAttempts();
		return attempts;
	}

	private void requestAttempts() {
		try {
			attempts.input(Console.readLine());
		} catch (IllegalArgumentException illegalArgumentException) {
			ErrorView.show(illegalArgumentException.getMessage());
			requestAttempts();
		}
	}
}
