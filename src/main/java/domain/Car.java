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

        if (randomNumber >= 4){
            this.position += 1;
        }
    }
}
