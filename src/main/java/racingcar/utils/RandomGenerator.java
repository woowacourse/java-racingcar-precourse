package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;
import static racingcar.utils.Constant.*;

public class RandomGenerator {
	public int getRandomNum() {
		return Randoms.pickNumberInRange(RANDOM_NUM_MIN, RANDOM_NUM_MAX);
	}
}
