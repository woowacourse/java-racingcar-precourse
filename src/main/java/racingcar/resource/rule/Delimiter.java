package racingcar.resource.rule;

public enum Delimiter {

    COMMA(",");

    private final String value;

    Delimiter(String value) {
        this.value = value;
    }

    public static String[] splitWithComma(String targetString) {
        return targetString.split(COMMA.value);
    }

}
