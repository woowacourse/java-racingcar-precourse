package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.platform.commons.util.StringUtils;
import racingcar.utils.Consts;

import static racingcar.utils.Consts.MAX_RANDOM_NUMBER;
import static racingcar.utils.Consts.MIN_RANDOM_NUMBER;
import static racingcar.utils.ErrorMessage.INVALID_CAR_NAME;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        validateLength(name);
    }

    private void validateLength(String name) {
        if (name.length() > Consts.CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(INVALID_CAR_NAME.getMessage());
        }

        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException(INVALID_CAR_NAME.getMessage());
        }
    }

    public boolean move() {
        boolean moveFlag = isMove();
        if (moveFlag) {
            position++;
        }
        return moveFlag;
    }

    private boolean isMove() {
        int moveFlag = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
        return moveFlag >= 4;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
