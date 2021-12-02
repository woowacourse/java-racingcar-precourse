package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    public static final int START_INCLUSIVE = 0;
    public static final int END_INCLUSIVE = 9;

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void go() {
        if (Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE) >= 4) {
            position++;
        }
    }


}
