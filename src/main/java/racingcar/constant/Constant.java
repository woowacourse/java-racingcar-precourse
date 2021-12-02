package racingcar.constant;

public enum Constant {
    CAR_NAME_MAX_SIZE(5),

    RANDOM_NUMBER_MAX_SIZE(9),
    RANDOM_NUMBER_MIN_SIZE(0);

    private int value;

    Constant(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }
}
