package racingcar;

public class Car implements Comparable<Car> {
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
            move();
        }
    }

    private boolean isMovable(int random) {
        return random >= CRITICAL_VALUE_FOR_MOVE;
    }

    private void move() {
        position++;
    }

    @Override
    public int compareTo(Car object) {
        return Integer.compare(object.position, this.position);
    }
}
