package racingcar;

import java.util.Collections;

public class Car {

    private final int MOVE_FRONT_MIN = Constants.MOVE_FRONT_MIN.getValue();
    private final String positionIndicator = "-";
    private final String namePositionDelimiter = " : ";

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move(int moveValue) {
        if (moveValue >= MOVE_FRONT_MIN) {
            moveFront();
        }
    }

    public void moveFront() {
        position++;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public String getPositionString() {
        StringBuilder positionString = new StringBuilder();
        positionString.append(name);
        positionString.append(namePositionDelimiter);
        for (int i = 0; i < position; i++) {
            positionString.append(positionIndicator);
        }
        return positionString.toString();
    }

    public void setPosition(int position) {
        this.position = position;
    }

}
