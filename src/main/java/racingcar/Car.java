package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현
    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public void race() {
        int startInclusive = Constants.RACE_DICE_START_INCLUSIVE;
        int endInclusive = Constants.RACE_DICE_END_INCLUSIVE;
        int diceEyes = Randoms.pickNumberInRange(startInclusive, endInclusive);
        if (diceEyes >= 4) {
            position++;
        }
    }
}
