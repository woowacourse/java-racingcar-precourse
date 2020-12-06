package racingcar;

public enum Constants {
    RANDOM_MIN(0), RANDOM_MAX(9), MOVE_FRONT_MIN(4);

    private int value;

    Constants(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
