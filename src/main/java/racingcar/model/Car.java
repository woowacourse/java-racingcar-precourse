package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.util.RandomCondition;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void moveForwardOrStop() {
        if (pickRandomNumber() >= RandomCondition.MOVABLE) {
            position++;
        }
    }

    public void getCurrentInfo() {
        // TODO: 자동차 이름과 위치 정보
    }

    private int pickRandomNumber() {
        return Randoms.pickNumberInRange(RandomCondition.MIN, RandomCondition.MAX);
    }
}
