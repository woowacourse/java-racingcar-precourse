package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarNamesSplitList {

    public static List<String> carNamesSplitList(String carNames) {
        List<String> carNamesSplitList = new ArrayList<>(Arrays.asList(carNames.split(",")));

        return carNamesSplitList;
    }
}
