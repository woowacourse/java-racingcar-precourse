package racingcar.controller;

import racingcar.domain.CarRacingGame;
import racingcar.domain.Track;
import racingcar.view.InputView;

public class Application {

	public static final String SPLIT_REGEX = ",";

	public static void main(String[] args) {
		Track track = new Track(InputView.inputCarsName(SPLIT_REGEX));
		CarRacingGame carRacingGame = new CarRacingGame(InputView.inputMovesNumber());

		while (carRacingGame.checkOneMoreRoundPossible()) {
			track.play();
			carRacingGame.roundsAdd(track.makeRoundResult());
		}
	}
}
