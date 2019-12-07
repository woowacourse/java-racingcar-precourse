package domain;

import java.util.Random;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public void goAndStop() {
        int getNum = getRandomNumber();
        if (getNum >= 4) {
            this.position++;
        }
    }

    private int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(10);
    }
}
