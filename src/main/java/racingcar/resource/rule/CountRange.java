package racingcar.resource.rule;

public enum CountRange {

    MINIMUM(0);

    private final int number;

    CountRange(int number) {
        this.number = number;
    }

    public static boolean isTooSmall(int count) {
        return (count < MINIMUM.number);
    }

}
