package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {


    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move() {
        if(canMove()) position ++;
        printCurrentPosition();
    }

    private boolean canMove() {
        int moveCount = Randoms.pickNumberInRange(0, 9);

        return moveCount >= 4;
    }

    private void printCurrentPosition() {
        System.out.printf("%s : %s%n", name, getPositionString());
    }

    private String getPositionString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < position; i++) {
            sb.append("-");
        }

        return sb.toString();
    }
}
