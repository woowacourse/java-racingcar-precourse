package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
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

    public void move() {
        if(canMove()) position ++;
    }

    private boolean canMove() {
        int moveCount = Randoms.pickNumberInRange(0, 9);

        return moveCount >= 4;
    }
}
