package racingcar.domain;

public class Car {
    public static final int MIN_STANDARD_NUMBER = 4;

    private final String name;
    private int position = 0;

    public Car(String name) { this.name = name; }

    public void move(int value) {
        if (canIMove(value)) {
            position++;
        }
    }

    private boolean canIMove(int value) {
        return value >= MIN_STANDARD_NUMBER;
    }

    public int getPosition() {
        return this.position;
    }
}
