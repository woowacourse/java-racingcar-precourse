package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constant.Constant;

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

    public int getPosition() {
        return position;
    }

    public void SelectMoveOrStop() {
        if (generateRandomNumber() > 3) {
            Move();
        }
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(Constant.RANDOM_NUMBER_MIN_SIZE.value(),
                Constant.RANDOM_NUMBER_MAX_SIZE.value());
    }

    private void Move() {
        this.position++;
    }
}
