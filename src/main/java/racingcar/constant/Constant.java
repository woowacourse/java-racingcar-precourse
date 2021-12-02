package racingcar.constant;

public enum Constant {
    CAR_NAME_MAX_SIZE(5);

    private int value;

    Constant(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }
}
