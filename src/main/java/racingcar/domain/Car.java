package racingcar.domain;

public class Car {
    private static final int MOVING_BASELINE = 4;
    private static final String MARKER_BETWEEN_NAME_AND_POSITION = " : ";
    private static final String MARKER_OF_POSITION = "-";

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

    public String getCurrentPosition() {
        StringBuilder current = new StringBuilder(name);
        current.append(MARKER_BETWEEN_NAME_AND_POSITION);
        for (int i = 0; i < position; i++) {
            current.append(MARKER_OF_POSITION);
        }
        return current.toString();
    }
}
