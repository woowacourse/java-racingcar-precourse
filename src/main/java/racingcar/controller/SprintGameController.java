package racingcar.controller;

import racingcar.domain.car.CarSet;
import racingcar.domain.round.RacingRound;
import racingcar.service.SprintGameService;

public class SprintGameController implements GameController {

	private final SprintGameService gameService;

	public SprintGameController(SprintGameService gameService) {
		this.gameService = gameService;
	}

	@Override
	public boolean play(RacingRound round, CarSet carSet) {
		if (round.isOver()) {
			return false;
		}
		gameService.play(carSet);
		return round.decrease();
	}
}
