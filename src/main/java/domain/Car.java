package domain;

public class Car {
    static final int MIN_RANDOM_VALUE = 0;
    static final int MAX_RANDOM_VALUE = 9;
    static final int MOVE_OR_STOP_BOUNDARY_VALUE = 4;
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    private void moveOrStop() {
        int randomValue = 0;
//        randomValue = getRandomValue(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE);

        if (randomValue >= MOVE_OR_STOP_BOUNDARY_VALUE) {
            position++;
        }
    }
}
