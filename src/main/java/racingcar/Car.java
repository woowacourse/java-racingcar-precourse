package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Objects;

public class Car {
    private static final int STANDARD_NUMBER = 4;

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void go(int random) {
        if (isBiggerThanStandard(random)) {
            position++;
        }
    }

    private boolean isBiggerThanStandard(int num) {
        return STANDARD_NUMBER <= num;
    }
}
