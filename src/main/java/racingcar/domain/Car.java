package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private static final int START_INCLUSIVE = 0;
    private static final int END_INCLUSIVE = 9;
    private static final String SPEED_SIGNAL = "-";

    private final String name;
    private int position = 0;
    private String speed = "";

    public Car(String name) {
        this.name = name;
    }

    protected String getCarName() {
        return name;
    }

    protected String getSpeed() {
        return speed;
    }

    protected void moveForward() {
        position++;
    }

    protected boolean isFaster(Car winnerCarPosition) {
        return this.position > winnerCarPosition.position;
    }

    protected boolean isWinner(final Car winnerCarPosition) {
        return this.position == winnerCarPosition.position ;
    }

    protected boolean decideMoveCar(final int randomNumberToMove) {
        return randomNumberToMove > 3;
    }

    protected void addSpeed() {
        speed = speed + SPEED_SIGNAL;
    }

    protected int inputMoveForwardNumber() {
        return Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
    }

    protected void moveCar(Car car) {
        car.moveForward();
        car.addSpeed();
    }

}
