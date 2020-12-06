package racingcar.service;

public class NumberToDashConverter {
    public static final int MIN_INDEX_VALUE = 0;

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
