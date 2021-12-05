package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

/**
 * <h1>레이싱 게임에 필요한 난수를 생성하는 클래스</h1>
 * 레이싱게임에서 매 턴마다 각 차량 전진여부 판별을 위해 난수를 생성해야 한다.
 * 이 난수를 생성하는 인스턴스를 만드는 클래스이다
 *
 * @author yunki kim
 * @version 1.0
 * @since 2021-12-01(V1.0)
 */

public class RandomGenerator {

	private static final Integer RANDOM_NUMBER_MAX_RANGE = 9;

	private static final Integer RANDOM_NUMBER_MIN_RANGE = 0;

	public RandomGenerator() {
		super();
	}

	public Integer getRandomNumber() {
		return Randoms.pickNumberInRange(RANDOM_NUMBER_MIN_RANGE, RANDOM_NUMBER_MAX_RANGE);
	}
}
