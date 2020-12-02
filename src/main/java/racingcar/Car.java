package racingcar;

import racingcar.domain.CarMovingFlag;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void updatePositionByFlag(CarMovingFlag carMovingFlag) {
        if (carMovingFlag == CarMovingFlag.FORWARD) {
            this.position += 1;
        }
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }
}
