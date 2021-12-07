package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.Count;
import racingcar.domain.Names;
import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {
	public void runRacing() {
		RacingGame racingGame = RacingGame.getInstance();

		OutputView.printInputNamesInstruction();
		Cars cars = Cars.from(Names.from(InputView.getNames()));

		OutputView.printInputCountInstruction();
		Count count = Count.of(InputView.getCount());

		runRacing(racingGame, cars, count);

		OutputView.printFinalWinnerInstruction();
		OutputView.printNameOfFinalWinners(racingGame.findNameOfWinners());
	}

	private void runRacing(RacingGame racingGame, Cars cars, Count count) {
		racingGame.init();
		racingGame.insert(cars);
		while (count.isRacingEnd()) {
			racingGame.start();
			reportResultEveryRound(racingGame);
		}
	}

	private void reportResultEveryRound(RacingGame racingGame) {
		OutputView.printEveryRound(racingGame.getResults());
	}
}
