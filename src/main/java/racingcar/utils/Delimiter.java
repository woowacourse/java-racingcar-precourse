package racingcar.utils;

import java.util.List;

public enum Delimiter {

    COMMA(","),
    COLON(":"),
    SPACE(" "),
    BAR("-");

    private final String value;

    Delimiter(String value) {
        this.value = value;
    }

    public static String[] splitWithComma(String targetString) {
        return targetString.split(COMMA.value);
    }

    public static String appendSpaceBehind(String targetString) {
        return targetString + SPACE.value;
    }

    public static String joinWithComma(List<String> strings) {
        return String.join(COMMA.value + SPACE.value, strings);
    }

    public static String concatWithColon(String preString, String postString) {
        String separator = SPACE.value + COLON.value + SPACE.value;
        return preString + separator + postString;
    }

    public static String repeatUnderBar(int count) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            stringBuilder.append(BAR.value);
        }
        return stringBuilder.toString();
    }

}
