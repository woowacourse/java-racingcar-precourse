package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int GO_STOP_STANDARD = 4;
    private static final int DICE_MINIMUM = 0;
    private static final int DICE_MAXIMUM = 9;

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void goOrStop() {
        int number = rollTheDice();
        if (overStandard(number)) {
            run();
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    private int rollTheDice() {
        return Randoms.pickNumberInRange(DICE_MINIMUM, DICE_MAXIMUM);
    }

    private boolean overStandard(int number) {
        return number >= GO_STOP_STANDARD;
    }

    private void run() {
        this.position++;
    }

}
