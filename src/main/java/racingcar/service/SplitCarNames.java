package racingcar.service;

import java.util.Arrays;
import java.util.List;

import static racingcar.constant.Constants.ERROR_NO_COMMA;

public class SplitCarNames {

    private SplitCarNames() {
    }

    public static List<String> split(String carNames) {
        validateComma(carNames);
        return Arrays.asList(carNames.split(","));
    }

    private static void validateComma(String carNames) {

        if (!carNames.contains(",")) {
            throw new IllegalArgumentException(ERROR_NO_COMMA);
        }

    }
}
