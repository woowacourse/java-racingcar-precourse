package domain;

import java.util.ArrayList;
import java.util.Random;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public void move() {
        Random rand = new Random();
        int number = rand.nextInt(9);
        if (number >= 4) {
            this.position++;
        }
    }

}
