package utils;

import racingcar.domain.CarMovingFlag;

import java.util.ArrayList;
import java.util.List;

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

    public static List<CarMovingFlag> makeCarMovieFlagList(List<Integer> flagNumberList) {
        List<CarMovingFlag> carMovingFlagList = new ArrayList<>(flagNumberList.size());
        for (int flagNumber : flagNumberList) {
            carMovingFlagList.add(CarMovingFlagUtils.selectMovingFlag(flagNumber));
        }

        return carMovingFlagList;
    }
}
