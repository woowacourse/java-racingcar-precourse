package domain.Model;

import java.util.Random;

public class Car {
    Random rand = new Random();

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void isOverFour(int randomNumber) {
        if (randomNumber >= 4) {
            this.position++;
        }
    }

    public void canYouGo() {
        if (rand.nextInt() >= 4) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }
}
