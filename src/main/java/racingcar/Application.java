package racingcar;

import racingcar.domain.RacingGame;
import racingcar.domain.RacingRecord;
import racingcar.view.InputView;

public class Application {
	public static void main(String[] args) {
		String inputCarsName = InputView.getInputCarsName();
		int round = InputView.getInputRound();
		RacingGame racingGame = RacingGame.createRacingGame(inputCarsName, round);

		int roundCount = 0;
		while (racingGame.isContinue(roundCount)) {
			RacingRecord racingRecord = racingGame.race();
		}
	}
}
