package racingcar;

import racingcar.domain.RacingCarController;
import racingcar.view.InputView;

public class Application {
	public static void main(String[] args) {
		String[] names = InputView.inputToStringArray(InputView.carInput());
		int roundCount = InputView.inputToInt(InputView.roundInput());

		RacingCarController game = new RacingCarController();
		game.start(names, roundCount);
	}
}
