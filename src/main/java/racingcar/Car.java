package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import constant.ConsoleMessage;

public class Car {
    private static final int RANDOM_RANGE_MIN = 0;
    private static final int RANDOM_RANGE_MAX = 9;
    private static final int PROGRESS_CRITICAL_NUM = 4;

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void progressOrStop() {
        int randNum = Randoms.pickNumberInRange(RANDOM_RANGE_MIN, RANDOM_RANGE_MAX);
        if (randNum >= PROGRESS_CRITICAL_NUM) {
            position++;
        }
    }

    public void printCurrentPosition() {
        System.out.print(name);
        System.out.print(ConsoleMessage.COLON);
        for (int i = 0; i < position; i++) {
            System.out.print(ConsoleMessage.UNIT_DISTANCE);
        }
        System.out.print(ConsoleMessage.NEW_LINE);
    }
}
