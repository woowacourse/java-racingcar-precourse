package domain;

import java.util.Random;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    private void addPosition() {
        position++;
    }

    public void goOrStop() {
        Random random = new Random();
        final int bound = 10;
        final int condition = 3;

        int randomNum = random.nextInt(bound);

        if (randomNum > condition) {
            addPosition();
        }
    }
}
