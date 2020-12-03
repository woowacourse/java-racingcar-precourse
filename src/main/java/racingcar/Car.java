package racingcar;

public class Car implements Comparable<Car> {
    private static final int POSSIBLE_MOVE_POWER = 4;
    private static final String MOVING_STATE = "-";
    private static final String COLON = " : ";

    private final String name;
    private int position = 0;
    private StringBuilder state = new StringBuilder();

    public Car(String name) {
        this.name = name;
    }

    public void move(int power) {
        isMove(power);
    }

    private void isMove(int power) {
        if (power >= POSSIBLE_MOVE_POWER) {
            ++position;
            state.append(MOVING_STATE);
        }
    }

    public boolean equalsPosition(Car car) {
        return this.position == car.position;
    }

    @Override
    public String toString() {
        return name + COLON + state;
    }

    @Override
    public int compareTo(Car car) {
        return car.position - this.position;
    }

    public String getName() {
        return name;
    }
}
