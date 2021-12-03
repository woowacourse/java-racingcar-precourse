package racingcar.utils;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public enum RandomNumberBox {
	RANDOM_NUMBER_BOX_INSTANCE;
	private static final int RANDOM_NUMBER_MIN = 0;
	private static final int RANDOM_NUMBER_MAX = 9;

	public int getRandomNumber(){
		return pickNumberInRange(RANDOM_NUMBER_MIN, RANDOM_NUMBER_MAX);
	}

}
