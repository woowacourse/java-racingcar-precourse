package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Objects;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) throws IllegalArgumentException {
        validCarName(name);
        this.name = name;
    }

    private void validCarName(String name) throws IllegalArgumentException {
        emptyNullCheck(name);
        validLength(name);
    }

    private void emptyNullCheck(String name) {
        if (Objects.isNull(name) || name.isEmpty()) {
            throw new IllegalArgumentException("[ERROR]: 자동차의 이름은 1글자 이상 5글자 이하로 지정하여야 합니다.");
        }
    }

    private void validLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("[ERROR]: 자동차의 이름은 1글자 이상 5글자 이하로 지정하여야 합니다.");
        }
    }

    public void move() {
        int i = Randoms.pickNumberInRange(1, 9);
        if (i >= 4) {
            position++;
        }
    }

    public int position() {
        return position;
    }

    public String name() {
        return name;
    }
}
