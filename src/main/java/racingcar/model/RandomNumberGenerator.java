package racingcar.model;

import static racingcar.model.constants.GameRule.NUMBER_RANGE_END;
import static racingcar.model.constants.GameRule.NUMBER_RANGE_START;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements NumberGenerator {
    @Override
    public int make() {
        return Randoms.pickNumberInRange(NUMBER_RANGE_START, NUMBER_RANGE_END);
    }
}
