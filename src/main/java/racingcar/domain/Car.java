package racingcar.domain;

import static racingcar.util.RandomUtil.checkMoveOrWait;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void progress() {
        if(checkMoveOrWait()) {
            move();
        }
    }

    private void move() {
        this.position ++;
    }
}
