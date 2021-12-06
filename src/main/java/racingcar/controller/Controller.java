package racingcar.controller;

import racingcar.domain.RacingGame;
import racingcar.view.InputView;

public class Controller {
	public void runRacing() {
		//메인 로직
		RacingGame racingGame = RacingGame.getInstance();
		racingGame.init();

		String input = InputView.getInput();

	}
}
