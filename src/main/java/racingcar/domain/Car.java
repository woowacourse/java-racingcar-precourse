package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final String INFO_BETWEEN_WORD = " : ";
    private static final String POSITION_WORD = "-";
    private static final int RANDOM_MIN_RANGE = 0;
    private static final int RANDOM_MAX_RANGE = 9;
    private static final int RANDOM_CONDITION = 4;

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void carMove() {
        int randNum = Randoms.pickNumberInRange(RANDOM_MIN_RANGE, RANDOM_MAX_RANGE);

        if (randNum >= RANDOM_CONDITION) {
            this.position += 1;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void showInfo() {
        String info = getName() + INFO_BETWEEN_WORD;

        for (int i = 0; i < position; i++) {
            info += POSITION_WORD;
        }
        System.out.println(info);
    }
}
