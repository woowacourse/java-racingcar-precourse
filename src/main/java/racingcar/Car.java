package racingcar;

import utils.RandomUtils;

public class Car {
    private final String name;
    private int position = 0;
    static final int MOVE_FORWARD = 4;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void runRace() {
        int roundNumber = RandomUtils.nextInt(0, 9);

        if (judgeIfRun(roundNumber)) {
            position++;
        }
    }

    private boolean judgeIfRun(int roundNumber) {
        return roundNumber >= MOVE_FORWARD;
    }
}
