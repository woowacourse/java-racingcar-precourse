package racingcar.controller;

import racingcar.domain.CarRacingGame;
import racingcar.domain.Rounds;
import racingcar.domain.Track;
import racingcar.view.InputView;

public class Application {

	public static final String SPLIT_REGEX = ",";

	public static void main(String[] args) {
		Track track = new Track(InputView.inputCarsName(SPLIT_REGEX));
		CarRacingGame carRacingGame = new CarRacingGame(InputView.inputMovesNumber());
		Rounds rounds = new Rounds();

		while (carRacingGame.checkOneMoreRoundPossible()) {
			track.play();
			rounds.add(track.makeRoundResult());
		}
	}
}
