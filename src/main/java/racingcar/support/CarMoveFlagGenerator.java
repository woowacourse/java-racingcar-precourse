package racingcar.support;

import camp.nextstep.edu.missionutils.Randoms;

import static racingcar.utils.Consts.*;

public class CarMoveFlagGenerator implements RandomNumberGenerator {

    @Override
    public boolean generate() {
        int randomNumber = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);

        return randomNumber >= MIN_NUMBER_FOR_CAR_MOVE;
    }
}
