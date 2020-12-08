package racingcar;

import static game.Message.showStatus;
import static game.Rule.MOVING_STATE;
import static game.Rule.POSSIBLE_MOVE_POWER;

public class Car implements Comparable<Car> {
    private final String name;
    private int position = 0;
    private StringBuilder state = new StringBuilder();

    public Car(String name) {
        this.name = name;
    }

    public void move(final int power) {
        if (hasPower(power)) {
            move();
        }
    }

    private boolean hasPower(int power) {
        return power >= POSSIBLE_MOVE_POWER;
    }

    private void move() {
        ++position;
        state.append(MOVING_STATE);
    }

    public boolean equalsPosition(final Car car) {
        return this.position == car.position;
    }

    @Override
    public String toString() {
        return showStatus(name, state.toString());
    }

    @Override
    public int compareTo(final Car car) {
        return car.position - this.position;
    }

    public String getName() {
        return name;
    }
}
