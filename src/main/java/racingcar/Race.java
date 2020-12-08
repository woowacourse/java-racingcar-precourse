package racingcar;

import utils.RandomUtils;

import java.util.List;

public class Race {
    private final String MOVEMENT = "-";
    private int maxScore = 0;
//    private List<Car> cars;

//    public Race(List<Car> cars) {
//        this.cars = cars;
//    }

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

    public void movementCheck(Car car) {
        if (moveForward()) {
            car.setPosition();
        }
    }

    public void findMaximum(List<Car> cars) {
        for (Car car : cars) {
            int position = car.getPositon();
            if (position > maxScore) {
                maxScore = position;
            }
        }
    }

    public boolean moveForward() {
        int conditionNumber = RandomUtils.nextInt(0, 9);
        return conditionNumber > 3;
    }
}
