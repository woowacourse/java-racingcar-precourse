package racingcar.service.picker;

import camp.nextstep.edu.missionutils.Randoms;

import racingcar.utils.NumberRange;

public class RandomNumberPicker implements NumberPicker {

    public int pickOne() {
        return Randoms.pickNumberInRange(NumberRange.getMinimum(), NumberRange.getMaximum());
    }
}
