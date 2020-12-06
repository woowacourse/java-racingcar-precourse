package racingcar;

import static game.Message.showWinners;
import static game.Rule.MOVING_STATE;
import static game.Rule.POSSIBLE_MOVE_POWER;

public class Car implements Comparable<Car> {
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
        return showWinners(name, state.toString());
    }

    @Override
    public int compareTo(Car car) {
        return car.position - this.position;
    }

    public String getName() {
        return name;
    }
}
