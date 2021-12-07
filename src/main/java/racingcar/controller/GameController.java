package racingcar.controller;

import racingcar.domain.car.CarSet;
import racingcar.domain.round.RacingRound;

public interface GameController {
	boolean play(RacingRound round, CarSet carSet);
}
