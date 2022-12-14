package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements NumberGenerator {
    private static final int RANGE_START = 0;
    private static final int RANGE_END = 9;

    @Override
    public int make() {
        return Randoms.pickNumberInRange(RANGE_START, RANGE_END);
    }
}
