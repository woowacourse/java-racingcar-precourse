package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMoveStrategy implements MoveStrategy {

    private static final Integer MINIMUM_RANDOM_NUMBER = 1;
    private static final Integer MAXIMUM_RANDOM_NUMBER = 9;

    private static Integer MOVING_THRETHOLD = 4;

    @Override
    public boolean move() {
        return randomNumber() >= MOVING_THRETHOLD;
    }

    private int randomNumber() {
        return Randoms.pickNumberInRange(MINIMUM_RANDOM_NUMBER, MAXIMUM_RANDOM_NUMBER);
    }
}
