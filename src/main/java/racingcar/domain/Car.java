package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import static racingcar.ErrorCode.NOT_VALID_CAR_NAME;
import static racingcar.domain.constants.MovingRule.MOVING_MAX;
import static racingcar.domain.constants.MovingRule.MOVING_MIN;
import static racingcar.domain.constants.MovingRule.MOVING_RULE;
import static racingcar.domain.constants.MovingRule.MOVING_SYMBOL;

public class Car implements Comparable<Car> {
    private static final int NAME_LENGTH = 5;
    private final String name;
    private int position = 0;

    public Car(String name) {
        validateCarName(name);
        this.name = name;
    }

    public void validateCarName(String name) {
        if (name.length() > NAME_LENGTH) {
            NOT_VALID_CAR_NAME.throwError();
        }
    }

    public void move() {
        int randomNumber = Randoms.pickNumberInRange(MOVING_MIN, MOVING_MAX);

        if (randomNumber >= MOVING_RULE) {
            position++;
        }
    }

    public String getNameAndPosition() {
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < position; i++) {
            sb.append(MOVING_SYMBOL);
        }

        return name + " : " + sb;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Car other) {
        return this.position - other.position;
    }

}
