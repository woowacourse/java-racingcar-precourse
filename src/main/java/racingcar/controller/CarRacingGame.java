package racingcar.controller;

import racingcar.domain.Round;
import racingcar.domain.Rounds;
import racingcar.domain.Track;
import racingcar.view.InputView;

public class CarRacingGame {

	public static final String SPLIT_REGEX = ",";

	public static void readyGame() {
		Track track = new Track(InputView.inputCarsName(SPLIT_REGEX));
		int movesNumber = InputView.inputMovesNumber();

		Rounds rounds = new Rounds();

		for (int index = 0; index < movesNumber; index++) {
			rounds.add(play(track));
		}
		
	}

	public static Round play(Track track) {
		track.play();
		return track.makeRoundResult();
	}

}
