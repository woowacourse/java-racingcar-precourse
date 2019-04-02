package domain;

import java.util.Random;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void tryMove() {
        if (checkMove()) {
            position += 1;
        }
    }

    private boolean checkMove() {
        Random random = new Random();
        int randomNum = random.nextInt(10);
        if (randomNum >= 4) {
            return true;
        }
        return false;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }
}
