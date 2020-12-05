package racingcar.generator;

import racingcar.type.BoundaryType;
import utils.RandomUtils;

/**
 * 0~9 사이에서 random 값을 구하는 클래스
 *
 * @author Daeun Lee
 */
public class NumberGenerator {

    public static int generateNumber() {
        return RandomUtils.nextInt(BoundaryType.MINIMUM_RANDOM_NUMBER.getBoundary(),
                BoundaryType.MAXIMUM_RANDOM_NUMBER.getBoundary());
    }
}
