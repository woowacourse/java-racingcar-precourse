package racingcar.game.move;

import racingcar.game.model.Power;
import racingcar.game.service.PowerGenerator;

public class RandomMovableStrategy implements MovableStrategy {
	@Override
	public boolean isMovable() {
		Power power = PowerGenerator.generateRandomNumber();
		return power.isMovable();
	}

}
