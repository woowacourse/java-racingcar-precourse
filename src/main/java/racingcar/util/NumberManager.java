package racingcar.util;

public enum NumberManager {
    NAME_MIN_LENGTH(1),
    START_NUMBER(0),
    LAST_NUMBER(9),
    STANDARD_NUMBER(4);
    private int number;

    NumberManager(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
