package racingcar.service.picker;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberPicker implements NumberPicker {

    public int pickOne() {
        return Randoms.pickNumberInRange(0,9);
    }
}
