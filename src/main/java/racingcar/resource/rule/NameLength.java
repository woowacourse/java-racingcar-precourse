package racingcar.resource.rule;

public enum NameLength {

    MAXIMUM(5);

    private final int number;

    NameLength(int number) {
        this.number = number;
    }

    public static boolean isTooLong(String name) {
        return (name.length() > MAXIMUM.number);
    }

}
