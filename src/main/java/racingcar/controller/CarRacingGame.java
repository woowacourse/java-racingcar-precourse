package racingcar.controller;

import racingcar.domain.Track;
import racingcar.view.InputView;

public class CarRacingGame {

	public static final String SPLIT_REGEX = ",";

	public static void play() {
		Track track = new Track(InputView.inputCarsName(SPLIT_REGEX));
		InputView.inputMovesNumber();
		track.play();
	}

}
