package racingcar;

import racingcar.domain.RacingCarController;
import racingcar.view.InputView;

public class Application {
	public static void main(String[] args) {
		String[] names = InputView.getNames();
		int roundCount = InputView.getRoundCount();

		RacingCarController game = new RacingCarController();
		game.start(names, roundCount);
	}
}
