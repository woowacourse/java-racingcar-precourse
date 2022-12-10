package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import static racingcar.Message.Rule.*;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현

    public int getPosition() {
        return position;
    }

    public String getName() {
        return this.name;
    }

    public void accelerate() {
        int speed = Randoms.pickNumberInRange(MIN_SPEED.getConstant(), MAX_SPEED.getConstant());

        if (speed >= ABLE_TO_ACCELERATE.getConstant()) this.position++;
    }
}
