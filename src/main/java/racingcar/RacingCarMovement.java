package racingcar;

import utils.RandomUtils;

public class RacingCarMovement {

    public static boolean moveCar() {
        if (RandomUtils.nextInt(0, 9) <= 3) {
            return false;
        }
        return true;
    }
}
