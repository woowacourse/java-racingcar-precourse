package racingcar.service;

import static racingcar.constant.Constants.MIN_INDEX_VALUE;

public class NumberToDashConverter {

    private NumberToDashConverter() {
    }

    public static String convert(int number) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int index = MIN_INDEX_VALUE; index < number; index++) {
            stringBuilder.append("-");
        }

        return stringBuilder.toString();
    }
}
