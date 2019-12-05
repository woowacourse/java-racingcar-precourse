package domain;

import java.util.Random;

public class Car {
    private static final int RANDOM_NUMBER_RANGE = 10;

    private final String name;
    private int position = 0;


    Random random = new Random();

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public void moveForward(boolean moving) {
        if (moving) {
            this.position++;
        }
    }

    public int getRandomInt() {
        return random.nextInt(RANDOM_NUMBER_RANGE);
    }

    public boolean decideGoOrNot(int inputNumber) {
        if (inputNumber <= 3) {
            System.out.println("FALSE");
            return false;
        }
        System.out.println("TRUE");
        return true;
    }


}
