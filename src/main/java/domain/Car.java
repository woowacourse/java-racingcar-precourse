package domain;

import java.util.Random;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    String getName() {
        return this.name;
    }

    int getPosition() {
        return this.position;
    }

    void move() {
        Random rand = new Random();
        int num = rand.nextInt(9);
        if (num >= 4) {
            this.position++;
        }
    }
}