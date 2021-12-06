package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private final String name;
    private int position = 0;
    private String speed = "";

    private static final int START_INCLUSIVE = 0;
    private static final int END_INCLUSIVE = 9;
    private static final String SPEED_SIGNAL = "-";

    public Car(String name) {
        this.name = name;
    }

    public String getCarName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public String getSpeed() {
        return speed;
    }

    public void moveForward() {
        position++;
    }

    public boolean decideMoveCar(final int randomNumberToMove) {
        return randomNumberToMove > 3;
    }

    public void addSpeed() {
        speed = speed + SPEED_SIGNAL;
    }

    public int inputMoveForwardNumber() {
        return Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
    }

}
