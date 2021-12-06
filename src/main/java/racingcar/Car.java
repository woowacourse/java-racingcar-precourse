package racingcar;

import static camp.nextstep.edu.missionutils.Randoms.*;

public class Car {
    private int position = 0;
    private final String name;

    static final int MIN_NUMBER = 0;
    static final int MAX_NUMBER = 9;
    static final int TARGET_NUMBER = 4;

    public Car(String name) {
        this.name = name;
    }

    public void playMoving() {
        tryMoveForward();
        printResult();
    }

    public void tryMoveForward() {
        int randomNumber = pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
        if (randomNumber >= TARGET_NUMBER) {
            position++;
        }
    }

    public void printResult() {
        System.out.print(name + " : ");
        for (int i = 0; i < position; ++i) {
            System.out.print("-");
        }
        System.out.print("\n");
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
