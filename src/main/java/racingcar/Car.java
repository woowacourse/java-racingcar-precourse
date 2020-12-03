package racingcar;

public class Car {
    private static final int POSSIBLE_MOVE_POWER = 4;

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move(int power) {
        isMove(power);
    }

    private void isMove(int power) {
        if (power >= POSSIBLE_MOVE_POWER) {
            ++position;
        }
    }

    @Override
    public String toString() {
        return String.valueOf(position);
    }
}
