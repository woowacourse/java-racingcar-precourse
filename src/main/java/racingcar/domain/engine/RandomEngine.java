package racingcar.domain.engine;

import utils.RandomUtils;

/**
 * 이 클래스는 랜덤 숫자 생성기입니다.
 *
 * @author Byeonghwa Kim
 * @version 1.0
 */
public class RandomEngine implements Engine {

    private static final int MIN_HORSE_POWER = 0;
    private static final int MAX_HORSE_POWER = 9;

    @Override
    public int getDigit() {
        return RandomUtils.nextInt(MIN_HORSE_POWER, MAX_HORSE_POWER);
    }
}
