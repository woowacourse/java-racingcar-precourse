package domain;

import java.util.Random;

public class Car {
    private final String name;
    private int position = 0;
    private static final int MIN_MOVE_NUMBER = 4;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public void moveCar() {
        int randomNumber = getRandomNumber();
        if (randomNumber >= MIN_MOVE_NUMBER) {
            this.position++;
        }
    }

    public int getRandomNumber() {
        Random randomNumberMaker = new Random();
        int randomNumber = randomNumberMaker.nextInt(10);
        return randomNumber;
    }

    public String toString() {
        return this.name;
    }

    public boolean equals(Object obj) {
        Car carObj;
        String name;
        try {
            carObj = (Car) obj;
            name = carObj.getName();
        } catch (ClassCastException e) {
            return false;
        }
        if (this.getName().equals(name)) {
            return true;
        }
        return false;
    }
}
