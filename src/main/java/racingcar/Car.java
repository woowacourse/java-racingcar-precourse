package racingcar;

import static camp.nextstep.edu.missionutils.Randoms.*;

public class Car {
    private final String name;
    private final int CONDITION_TO_MOVE = 4;
    private final int READY_POSITION = 0;
    private int position = READY_POSITION;

    public Car(String name) {
        this.name = name;
    }

    public void tryMove() {
        if (isMovable()) {
            position++;
        }
    }

    private boolean isMovable() {
        return pickRandomNumber() >= CONDITION_TO_MOVE;
    }

    private int pickRandomNumber() {
        return pickNumberInRange(0, 9);
    }

    public void setReady() {
        position = READY_POSITION;
    }

    public void printStatus() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name);
        stringBuilder.append(" : ");
        for (int i = 0; i < position; i++) {
            stringBuilder.append("-");
        }
        System.out.println(stringBuilder);
    }
}
