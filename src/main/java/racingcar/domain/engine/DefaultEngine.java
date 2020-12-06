package racingcar.domain.engine;

import racingcar.domain.setting.EngineSetting;
import utils.RandomUtils;

public class DefaultEngine implements Engine {

    @Override
    public int getPower() {

        int randomNumber = getRandomNumber();

        if (canMove(randomNumber)) {
            return EngineSetting.MOVE;
        }

        return EngineSetting.STAY;
    }

    private int getRandomNumber() {
        return RandomUtils.nextInt(EngineSetting.RANDOM_MIN_NUMBER, EngineSetting.RANDOM_MAX_NUMBER);
    }

    private boolean canMove(int number) {
        if (number < EngineSetting.REQUIRE_POWER) {
            return false;
        }
        return true;
    }

}
