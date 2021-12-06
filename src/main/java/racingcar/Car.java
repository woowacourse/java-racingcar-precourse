package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int MIN_RANGE_NUMBER = 0;
    private static final int MAX_RANGE_NUMBER = 9;
    private static final int PROCEED_MIN_NUMBER = 4;
    private static final String PROCEED_STATUS_UNIT = "-";

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void turn() {
        if (decideToProceed()) {
            this.position++;
        }
    }

    private boolean decideToProceed() {
        return Randoms.pickNumberInRange(MIN_RANGE_NUMBER, MAX_RANGE_NUMBER) >= PROCEED_MIN_NUMBER;
    }

    public void printInfo() {
        System.out.print(name + " : ");
        for (int i = 0; i < position; i++) {
            System.out.print(PROCEED_STATUS_UNIT);
        }
        System.out.println();
    }
}
