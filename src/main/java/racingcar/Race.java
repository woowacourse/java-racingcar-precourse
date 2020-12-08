package racingcar;

import utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private final String MOVEMENT = "-";
    private int maxPosition = 0;

    public void move(Car car) {
        String name;
        int position;

        moveToForward(car);

        name = car.getName();
        position = car.getPosition();

        String movement = "";
        for (int p=0; p<position; p++) {
            movement = movement.concat(MOVEMENT);
        }
        System.out.println(name + " : " + movement);
    }

    private void moveToForward(Car car) {
        if (movementCheck()) {
            car.setPosition();
        }
    }

    private boolean movementCheck() {
        int conditionNumber = RandomUtils.nextInt(0, 9);
        return conditionNumber > 3;
    }

    public void findMaximumPosition(List<Car> cars) {
        for (Car car : cars) {
            int position = car.getPosition();
            if (position > maxPosition) {
                maxPosition = position;
            }
        }
    }

    public List<String> getWinner(List<Car> cars) {
        List<String> winner = new ArrayList<>();
        for (Car car : cars) {
            int position = car.getPosition();
            String name = car.getName();
            if (position == maxPosition) {
                winner.add(name);
            }
        }
        return winner;
    }
}
