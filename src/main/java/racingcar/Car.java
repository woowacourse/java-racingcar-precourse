package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    static final int RANDOM_RANGE_MIN = 0;
    static final int RANDOM_RANGE_MAX = 9;

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void progressOrStop() {
        int randNum = Randoms.pickNumberInRange(RANDOM_RANGE_MIN, RANDOM_RANGE_MAX);
        if (randNum >= 4) {
            position++;
        }
    }

    public void printCurrentPosition() {
        System.out.print(name);
        System.out.print(" : ");
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.print("\n");
    }
}
