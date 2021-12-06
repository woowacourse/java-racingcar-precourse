package racingcar.controller;

import racingcar.domain.Count;
import racingcar.domain.Names;
import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {
	public void runRacing() {
		//메인 로직
		RacingGame racingGame = RacingGame.getInstance();
		racingGame.init();

		OutputView.printInputNamesInstruction();
		Names names = Names.from(InputView.getNames());

		OutputView.printInputCountInstruction();
		Count count = Count.of(InputView.getCount());
		System.out.println(count.getCount());

	}
}
