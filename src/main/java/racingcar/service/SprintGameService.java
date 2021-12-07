package racingcar.service;

import racingcar.domain.car.CarSet;
import racingcar.domain.movement.MovementStrategy;

public class SprintGameService implements GameService {

	private final MovementStrategy strategy;

	public SprintGameService(MovementStrategy strategy) {
		this.strategy = strategy;
	}

	@Override
	public void play(CarSet carSet) {
		carSet.move(strategy);
	}
}
