package racingcar.strategy;

import static camp.nextstep.edu.missionutils.Randoms.*;

public class RandomNumberStrategy implements MoveStrategy{
	private static final int MIN_NUMBER = 0;
	private static final int MAX_NUMBER = 9;
	private static final int PASS_NUM = 4;

	@Override
	public boolean isMoveable() {
		return checkMoveCondition();
	}

	private boolean checkMoveCondition() {
		int randomNum = pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
		if (randomNum >= PASS_NUM) {
			return true;
		}
		return false;
	}

}
