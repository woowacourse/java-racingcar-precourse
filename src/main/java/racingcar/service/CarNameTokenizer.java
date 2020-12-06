package racingcar.service;

import java.util.Arrays;
import java.util.List;

public class CarNameTokenizer {
    public static final String ERROR_NO_COMMA = "[ERROR] 자동차 이름은 \",\"로 구분되야 한다.";

    private CarNameTokenizer() {
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
