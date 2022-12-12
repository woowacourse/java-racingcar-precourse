package racingcar.support;

import camp.nextstep.edu.missionutils.Randoms;

public class CarMoveFlagGenerator implements RandomNumberGenerator<Boolean> {
    
    public static final int MIN_RANDOM_NUMBER = 0;
    public static final int MAX_RANDOM_NUMBER = 9;
    public static final int MIN_NUMBER_FOR_CAR_MOVE = 4;

    @Override
    public Boolean generate() {
        int randomNumber = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);

        return randomNumber >= MIN_NUMBER_FOR_CAR_MOVE;
    }
}
