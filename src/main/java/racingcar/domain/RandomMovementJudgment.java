package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMovementJudgment {
	private static final int RANDOM_MOVE_MIN = 0;
	private static final int RANDOM_MOVE_MAX = 9;
	private static final int MOVE_BASE = 4;

	public static boolean checkCarMove() {
		return Randoms.pickNumberInRange(RANDOM_MOVE_MIN, RANDOM_MOVE_MAX) >= MOVE_BASE;
	}
}
