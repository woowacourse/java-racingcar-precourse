package racingcar.resource.rule;

import java.util.List;

public enum Delimiter {

    COMMA(","),
    COLON(":"),
    SPACE(" "),
    UNDER_BAR("_");

    private final String value;

    Delimiter(String value) {
        this.value = value;
    }

    public static String[] splitWithComma(String targetString) {
        return targetString.split(COMMA.value);
    }

    public static String joinWithComma(List<String> strings) {
        return String.join(COLON.value + SPACE.value, strings);
    }

    public static String concatWithColon(String preString, String postString) {
        String separator = SPACE.value + COLON.value + SPACE.value;
        return preString + separator + postString;
    }

    public static String repeatUnderBar(int count) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            stringBuilder.append(UNDER_BAR.value);
        }
        return stringBuilder.toString();
    }

}
