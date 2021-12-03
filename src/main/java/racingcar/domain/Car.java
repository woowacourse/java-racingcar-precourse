package racingcar.domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public boolean attemptMove(int number) {
        if (isMovable(number)) {
            position++;
            return true;
        }
        return false;
    }

    private boolean isMovable(int number) {
        return number >= 4;
    }

    public int getPosition() {
        return position;
    }
}
