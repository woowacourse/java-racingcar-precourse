package racingcar.util;

public enum Number {
    START_NUMBER(0),
    LAST_NUMBER(9);
    private int number;

    Number(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
