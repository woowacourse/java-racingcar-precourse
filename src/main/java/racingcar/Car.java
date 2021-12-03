package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    public static final int STANDARD = 4;
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public int makeRandomForAdvance() {
        return Randoms.pickNumberInRange(0,9);
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
