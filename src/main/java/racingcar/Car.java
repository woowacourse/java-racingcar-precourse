package racingcar;

import utils.RandomUtils;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void moveCar() {
        int randomMove = RandomUtils.nextInt(0, 9);
        if (randomMove > 3) {
            this.position += 1;
        }
    }

    public int getPosition() {
        return this.position;
    }
}
