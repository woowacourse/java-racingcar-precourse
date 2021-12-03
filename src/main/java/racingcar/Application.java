package racingcar;

import racingcar.domain.RacingGame;
import racingcar.view.InputView;

public class Application {
	public static void main(String[] args) {
		String inputCarsName = InputView.getInputCarsName();
		int round = InputView.getInputRound();
		RacingGame racingGame = RacingGame.createRacingGame(inputCarsName, round);
	}
}
