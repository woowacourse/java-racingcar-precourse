package racingcar;

import utils.RandomUtils;

public class MoveCondition {
    public static boolean isMovable() {
        return RandomUtils.nextInt(0, 9) >= 4;
    }
}
