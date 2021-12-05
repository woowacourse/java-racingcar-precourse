package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMovingStrategy implements MovingStrategy {

	@Override
	public boolean isMovable() {
		int randomNumbers = Randoms.pickNumberInRange(0, 9);
		if (randomNumbers >= 4) {
			return true;
		}
		return false;
	}
}
