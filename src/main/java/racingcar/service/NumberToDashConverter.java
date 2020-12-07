package racingcar.service;

public class NumberToDashConverter {
    public static final int INDEX_VALUE_MIN = 0;

    private NumberToDashConverter() {
    }

    public static String convert(int number) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int index = INDEX_VALUE_MIN; index < number; index++) {
            stringBuilder.append("-");
        }

        return stringBuilder.toString();
    }
}
