package domain;

import java.util.Random;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void tryToGoForward() {
        Random random = new Random();
        int randomNumber = random.nextInt(9);

        if (randomNumber >= 4) {
            this.position += 1;
        }
    }

    public void printCurrentStatus() {
        System.out.printf("%s : %s\n", this.name, "-".repeat(this.position));
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }
}
