package racingcar.controller;

import java.util.List;

import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {
	public void runRacing() {
		//메인 로직
		RacingGame racingGame = RacingGame.getInstance();
		racingGame.init();

		OutputView.printInputNamesInstruction();
		List<String> names = InputView.getNames();
		System.out.println(names);

	}
}
