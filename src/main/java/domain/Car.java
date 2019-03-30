package domain;
import java.util.Random;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void printPosition() {
        System.out.println(name + " : " + position);
    }

    public void decideMovement() {
        final int minMoveSize = 4;
        if (getNewNumber() >= minMoveSize)
            position += 1;
    }

    private static int getNewNumber() {
        Random randomNumber = new Random();
        final int numberUpperBound = 10;
        return randomNumber.nextInt(numberUpperBound);
    }
}
