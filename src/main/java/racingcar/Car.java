package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    public static final int STANDARD = 4;
    public static final int ADVANCE_RANGE_LOWEST = 0;
    public static final int ADVANCE_RANGE_HIGHEST = 9;

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public int makeRandomForAdvance() {
        return Randoms.pickNumberInRange(ADVANCE_RANGE_LOWEST, ADVANCE_RANGE_HIGHEST);
    }

    public void predicateAdvance() {
        if (this.makeRandomForAdvance() >= STANDARD) {
            this.position++;
        }
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

}
