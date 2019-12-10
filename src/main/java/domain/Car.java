package domain;

import java.util.Random;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    int generateRandomNumber(){
        Random random = new Random();
        return random.nextInt();
    }

}
