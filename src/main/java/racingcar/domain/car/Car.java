package racingcar.domain.car;

import java.util.Objects;

public class Car {

    private static final int CAN_MOVE_INDICATOR = 4;
    private static final int CAR_NAME_LENGTH_LIMIT = 5;

    private final String name;
    private int position = 0;
    private String positionString = "";

    public Car(String name) {
        validate(name);
        this.name = name;
    }

    public void validate(String name) {
        isCorrectLength(name);
    }

    private void isCorrectLength(String name) {
        if (name.length() > CAR_NAME_LENGTH_LIMIT || name.isEmpty()) {
            throw new CarNameLengthMustBetweenOneToFiveException();
        }
    }

    public void tryMove(int randomNumber) {
        if (randomNumber >= CAN_MOVE_INDICATOR) {
            move();
        }
    }

    private void move() {
        position++;
    }

    public String getState() {
        return String.format("%s : %s", name, getPositionString());
    }

    private String getPositionString() {
        if (Objects.equals(positionString.length(), position)) {
            return positionString;
        }

        positionString += '-';
        return positionString;
    }
}
