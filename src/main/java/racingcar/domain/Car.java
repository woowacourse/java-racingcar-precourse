package racingcar.domain;

import java.util.Collections;

import static racingcar.utils.Constant.*;

public class Car {

    private final String name;
    private int position = ZERO_NUMBER;

    public Car(String name) {
        this.name = name;
    }

    public void moveOrStay(int randomNumber) {
        if (randomNumber >= MOVE_JUDGE) {
            position++;
        }
        printPosition();
    }

    public void printPosition() {
        String bar = String.join("", Collections.nCopies(this.position, BAR));
        System.out.println(name + " : " + bar);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public boolean isMaxPosition(int maxNumber) {
        return maxNumber == position;
    }
}