package racingcar.controller;

import racingcar.domain.car.CarSet;
import racingcar.domain.round.Round;

public interface GameController {
	boolean play(Round round, CarSet carSet);
}
