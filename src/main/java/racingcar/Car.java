package racingcar;

public class Car {
    private static final int CRITICAL_VALUE_FOR_MOVE = 4;

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void attemptToMove(int random) {
        if (isMovable(random)) {
            position++;
        }
    }

    private boolean isMovable(int random) {
        return random >= CRITICAL_VALUE_FOR_MOVE;
    }
}
