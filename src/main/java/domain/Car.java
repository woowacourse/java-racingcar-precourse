package domain;

import java.util.Random;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    private boolean goOrStop() {
        Random generator = new Random();

        return generator.nextInt(10) >= 4;
    }

    public void proceed() {
        if (goOrStop()) {
            this.position++;
        }
    }
}
