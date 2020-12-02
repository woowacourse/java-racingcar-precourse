package racingcar;

import utils.RandomUtils;

public class Car {

    public static final int GO_FORWARD_MIN_NUMBER = 4;
    public static final int KEEP_POSITION_MAX_NUMBER = 3;
    public static final int MOVING_POSITION_POINT = 1;
    public static final int MIN_RANDOM_RANGE = 0;
    public static final int MAX_RANDOM_RANGE = 9;

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현

    private void moveForwardCar() {
        if (isMoveForward()) {
            position += MOVING_POSITION_POINT;
        }
    }

    public int getPosition() {
        return position;
    }

    private boolean isMoveForward() {
        int randomNumber = RandomUtils.nextInt(MIN_RANDOM_RANGE, MAX_RANDOM_RANGE);
        if (randomNumber >= GO_FORWARD_MIN_NUMBER) {
            return true;
        }
        if (randomNumber <= KEEP_POSITION_MAX_NUMBER) {
            return false;
        }
        return false;
    }

    public static void main(String[] args) {
        Car theCar = new Car("testCar");
        theCar.moveForwardCar();
        theCar.moveForwardCar();
        theCar.moveForwardCar();
        theCar.moveForwardCar();
        theCar.moveForwardCar();
        System.out.println(theCar.name);
        System.out.println(theCar.getPosition());
    }

}
