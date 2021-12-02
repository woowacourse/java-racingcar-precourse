package racingcar;

import static camp.nextstep.edu.missionutils.Randoms.*;

public class RandomUtil {
	private static final int MIN_NUMBER = 0;
	private static final int MAX_NUMBER = 9;
	int randomNum;

	RandomUtil() {
		randomNum = pickNumberInRange(MIN_NUMBER, MAX_NUMBER); //생성자 초기화
	}
}
