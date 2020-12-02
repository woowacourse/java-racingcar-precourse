package utils;

import racingcar.domain.CarMovingFlag;

public class CarMovingFlagUtils {
    private static final int MIN_STOP_NUMBER = 0;
    private static final int MAX_STOP_NUMBER = 3;
    private static final int MIN_FORWARD_NUMBER = 4;
    private static final int MAX_FORWARD_NUMBER = 9;

    private CarMovingFlagUtils() {
    }

    public static CarMovingFlag selectMovingFlag(int flagNumber) {
        if (MIN_FORWARD_NUMBER <= flagNumber && flagNumber <= MAX_FORWARD_NUMBER) {
            return CarMovingFlag.FORWARD;
        } else if (MIN_STOP_NUMBER <= flagNumber && flagNumber <= MAX_STOP_NUMBER) {
            return CarMovingFlag.STOP;
        }

        throw new IllegalArgumentException();
    }

}
