package racingcar.domain.engine;

import utils.RandomUtils;

public class DefaultEngine implements Engine {

    private static final int RANDOM_MAX_NUMBER = 9;
    private static final int RANDOM_MIN_NUMBER = 0;
    private static final int STOP = 0;
    private static final int MOVE = 1;
    private static final int REQUIRE_POWER = 4;

    @Override
    public int getPower() {

        int randomNumber = getRandomNumber();

        if(canMove(randomNumber)){
            return MOVE;
        }

        return STOP;
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
