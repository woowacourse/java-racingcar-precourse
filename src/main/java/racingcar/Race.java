package racingcar;

import utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private final String MOVEMENT = "-";
    private int maxScore = 0;

    public void move(Car car) {
        String name;
        int position;

        movementCheck(car);

        name = car.getName();
        position = car.getPositon();

        String movement = "";
        for (int p=0; p<position; p++) {
            movement = movement.concat(MOVEMENT);
        }
        System.out.println(name + " : " + movement);
    }

    private void movementCheck(Car car) {
        if (moveForward()) {
            car.setPosition();
        }
    }

    private boolean moveForward() {
        int conditionNumber = RandomUtils.nextInt(0, 9);
        return conditionNumber > 3;
    }

    public void findMaximum(List<Car> cars) {
        for (Car car : cars) {
            int position = car.getPositon();
            if (position > maxScore) {
                maxScore = position;
            }
        }
    }

    public List<String> getWinner(List<Car> cars) {
        List<String> winner = new ArrayList<>();
        for (Car car : cars) {
            int position = car.getPositon();
            String name = car.getName();
            if (position == maxScore) {
                winner.add(name);
            }
        }
        return winner;
    }
}
