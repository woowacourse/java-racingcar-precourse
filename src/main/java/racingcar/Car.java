package racingcar;

import java.util.Collections;

public class Car {

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void moveOrStay(int randomNumber) {
        if (randomNumber >= 4) {
            position++;
        }
        printPosition();
    }

    public void printPosition() {
        String bar = String.join("", Collections.nCopies(this.position, "-"));
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