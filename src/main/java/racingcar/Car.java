package racingcar;

import utils.RandomUtils;

public class Car {

    public static final int GO_FORWARD_MIN_NUMBER = 4;
    public static final int KEEP_POSITION_MAX_NUMBER = 3;

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현

    private void moveForwardCar() {
        if (isMoveForward()) {
            position += 1;
        }
    }

    private boolean isMoveForward() {
        int randomNumber = RandomUtils.nextInt(0, 9);
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
        System.out.println(theCar.name);
    }

}
