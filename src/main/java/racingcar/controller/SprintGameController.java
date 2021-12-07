package racingcar.controller;

import racingcar.domain.car.CarSet;
import racingcar.domain.round.Round;
import racingcar.service.SprintGameService;

public class SprintGameController implements GameController {

	private final SprintGameService gameService;

	public SprintGameController(SprintGameService gameService) {
		this.gameService = gameService;
	}

	@Override
	public boolean play(Round round, CarSet carSet) {
		if (round.isOver()) {
			return false;
		}
		gameService.play(carSet);
		return round.decrease();
	}
}
