package racingcar;

import utils.RandomUtils;

public class Car {
    private final String name;
    private int position = 0;
    static final int RANDOM_MIN_NUM = 0;
    static final int RANDOM_MAX_NUM = 9;
    static final int MOVE_FORWARD = 4;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void runRace() {
        int roundNumber = RandomUtils.nextInt(RANDOM_MIN_NUM, RANDOM_MAX_NUM);

        if (judgeIfRun(roundNumber)) {
            position++;
        }
    }

    private boolean judgeIfRun(int roundNumber) {
        return roundNumber >= MOVE_FORWARD;
    }
}
