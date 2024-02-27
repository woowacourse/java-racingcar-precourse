package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int position = 0;

    private final int MIN_RANGE = 0;
    private final int MAX_RANGE = 9;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public void attemptRace() {
        if (Randoms.pickNumberInRange(MIN_RANGE, MAX_RANGE) >= 4) {
            position++;
        }
    }

    public String currentPosition() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.position; i++) {
            sb.append("-");
        }

        return sb.toString();
    }
}
