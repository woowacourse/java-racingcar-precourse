package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber implements Number {

    private final int START = 0;
    private final int END = 9;

    @Override
    public int generate() {
        return Randoms.pickNumberInRange(START, END);
    }
}
