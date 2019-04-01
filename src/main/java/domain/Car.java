package domain;

import java.util.Random;

public class Car {
    private final String name;
    private int position = 0;
    static final int threshold = 4;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public void move() {
        Random rand = new Random();
        int randomValue = rand.nextInt(10);
        int ismoving = randomValue > threshold ? 1 : 0;
        this.position += ismoving;
    }

}
