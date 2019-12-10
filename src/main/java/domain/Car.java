package domain;

import java.util.Random;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void tryToGoForward(int randomNumber) {
        final int moveCriteria = 4;

        if (randomNumber >= moveCriteria) {
            this.position += 1;
        }
    }

    public void printCurrentStatus() {
        System.out.printf("%s : %s\n", this.name, "-".repeat(this.position));
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }
}
