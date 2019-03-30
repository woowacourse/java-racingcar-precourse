package domain;

import java.util.Random;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void updatePosition() {
        int randomNum = generateRandom();

        if (randomNum > 3) {
            position++;
        }
    }

    private int generateRandom() {
        return new Random().nextInt(9);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
