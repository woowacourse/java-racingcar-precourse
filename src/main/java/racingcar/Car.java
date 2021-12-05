package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public void stopOrGo() {
        if (random()) {
            this.position++;
        }
    }

    private boolean random() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            return true;
        }
        return false;
    }

    // 추가 기능 구현
}
