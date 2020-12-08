package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarNamesSplitList {
    private final static String CAR_NAME_SPLITER = ",";

    public static List<String> carNamesSplitList(String carNames) {
        return new ArrayList<>(Arrays.asList(carNames.split(CAR_NAME_SPLITER)));
    }
}
