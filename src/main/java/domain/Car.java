package domain;

import java.util.Random;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    void goingForward() {
        Random random = new Random();
        int criterionValue = random.nextInt(9);
        if (criterionValue >= 4) {
            position++;
        }
    }

    int getPosition() {
        return position;
    }
}
