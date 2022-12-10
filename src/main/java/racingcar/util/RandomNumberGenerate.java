package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

import static racingcar.util.NumberManager.*;

public class RandomNumberGenerate implements NumberGenerate {

    @Override
    public int generate() {
        return Randoms.pickNumberInRange(START_NUMBER.getNumber(), LAST_NUMBER.getNumber());
    }
}
