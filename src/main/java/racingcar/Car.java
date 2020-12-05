package racingcar;

import utils.RandomUtils;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현
    public String getName() {
        return name;
    }

    boolean isMove() {
        int randomInt = RandomUtils.nextInt(0, 9);
        if (randomInt >= 4) {
            return true;
        }
        return false;
    }

    int move() {
        boolean isMove = isMove();
        if (isMove) {
            position++;
        }
        return position;
    }
}
