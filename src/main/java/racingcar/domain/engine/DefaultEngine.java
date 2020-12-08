package racingcar.domain.engine;

import static racingcar.domain.setting.EngineSetting.*;

import utils.RandomUtils;

public class DefaultEngine implements Engine {

    @Override
    public int getPower() {

        int randomNumber = getRandomNumber();

        if (canMove(randomNumber)) {
            return MOVE;
        }

        return STAY;
    }

    private int getRandomNumber() {
        return RandomUtils.nextInt(RANDOM_MIN_NUMBER, RANDOM_MAX_NUMBER);
    }

    private boolean canMove(int number) {
        if (number < REQUIRE_POWER) {
            return false;
        }
        return true;
    }

}
