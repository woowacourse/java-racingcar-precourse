package racingcar.type;

public enum ValueType {

    ZERO(0);

    private final int value;

    ValueType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
