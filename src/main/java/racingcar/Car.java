package racingcar;

import racingcar.constant.Condition;

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

    public void isNameOutOfRange(String carName) throws IllegalArgumentException {
        if (carName.length() > Condition.MAXIMUM_CAR_NAME_INPUT_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public void isNameNull(String carName) throws IllegalArgumentException {
        if (carName.length() < Condition.MINIMUM_CAR_NAME_INPUT_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public void forward(int randomNumber) {
        if (randomNumber >= Condition.MINIMUM_NUMBER_FOR_FORWARD) {
            position ++;
        }
    }
}
