package domain;

import java.util.Random;

public class Car {
    Random rand = new Random();

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    String getName() {
        return this.name;
    }

    void isOverFour(int randomNumber) {
        if (randomNumber >= 4) {
            this.position++;
        }
    }

    void canYouGo() {
        if (rand.nextInt() >= 4) {
            position++;
        }
    }

    int getPosition() {
        return position;
    }
}
