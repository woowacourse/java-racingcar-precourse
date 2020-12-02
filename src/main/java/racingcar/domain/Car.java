package racingcar.domain;

public class Car {
    private static final int MOVING_BASELINE = 4;

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void movePosition(int movingNumber) {
        if (movingNumber >= MOVING_BASELINE) {
            position++;
        }
    }
}
