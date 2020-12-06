package racingcar.domain.engine;

import racingcar.domain.setting.CarSetting;
import utils.RandomUtils;

public class DefaultEngine implements Engine {

    @Override
    public int getPower() {

        int randomNumber = getRandomNumber();

        if (canMove(randomNumber)) {
            return CarSetting.MOVE.get();
        }

        return CarSetting.STAY.get();
    }

    private int getRandomNumber() {
        return RandomUtils.nextInt(CarSetting.RANDOM_MIN_NUMBER.get(), CarSetting.RANDOM_MAX_NUMBER.get());
    }

    private boolean canMove(int number) {
        if (number < CarSetting.REQUIRE_POWER.get()) {
            return false;
        }
        return true;
    }

}
