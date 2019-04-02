package domain;

import java.util.Random;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    private boolean checkMove() {
        Random random = new Random();
        int randomNum = random.nextInt(10);
        if (randomNum >= 4) {
            return true;
        }
        return false;
    }
}
