package racingcar.game.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.game.model.Power;

public class PowerGenerator {
	private static final int MIN_NUMBER = 0;
	private static final int MAX_NUMBER = 9;

	public static Power generateRandomNumber() {
		return Power.valueOf(Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER));
	}

}
