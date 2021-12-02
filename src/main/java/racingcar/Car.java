package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private final String name;
    private int position = 0;

    public static final int START_INCLUSIVE = 0;
    public static final int END_INCLUSIVE = 9;

    public Car(String name) {
        this.name = name;
    }

    public String getCarName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void moveForward() {
        position++;
    }

    public int inputMoveForwardNumber() {
        return Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
    }

    public boolean decideMoveCar(final int randomNumberToMove) {
        return randomNumberToMove > 3;
    }


    // 추가 기능 구현
}
