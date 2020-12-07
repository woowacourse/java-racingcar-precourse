package racingcar.domain.car;

import utils.RandomUtils;

public class Car implements CarInterface {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    @Override
    public int drive() {
        if (shouldGo()) {
            position++;
            return 1;
        }
        return 0;
    }

    private boolean shouldGo() {
        int randomValue = RandomUtils.nextInt(0, 9);
        if (randomValue >= 4) {
            return true;
        }
        return false;
    }

    public int getPosition() {
        return position;
    }
}
