package racingcar.domain;

import org.junit.platform.commons.util.StringUtils;
import racingcar.support.CarMoveFlagGenerator;
import racingcar.support.RandomNumberGenerator;

import static racingcar.utils.Consts.CAR_NAME_LENGTH;
import static racingcar.utils.ErrorMessage.INVALID_CAR_NAME;

public class Car {
    private final String name;
    private int position = 0;
    private final RandomNumberGenerator flagGenerator = new CarMoveFlagGenerator();

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        validateLength(name);
    }

    private void validateLength(String name) {
        if (name.length() > CAR_NAME_LENGTH) {
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
        return flagGenerator.generate();
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public String toMessage() {
        String movement = "-".repeat(position);
        return name + " : " + movement;
    }
}
