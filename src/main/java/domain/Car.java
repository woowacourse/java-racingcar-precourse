package domain;

import java.util.Random;

public class Car {
    private final String name;
    private int position = 0;
    private final int THRESHOLD_VALUE = 4;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public boolean isMoreThanThreshold() {
        Random random = new Random();
        int bound = 10;
        int randomNumber = random.nextInt(bound);
        if (randomNumber >= this.THRESHOLD_VALUE) {
            return true;
        }
        return false;
    }

    public void decideMoveOrNot() {
        int distance = 1;
        if (!isMoreThanThreshold()) {
            return;
        }
        this.position += distance;
    }

    public String visualizePosition() {
        int currentPosition = this.getPosition();
        String visualizedPosition = "";
        String hyphen = "-";
        for (int i = 0; i < currentPosition; i++) {
            visualizedPosition += hyphen;
        }
        return visualizedPosition;
    }
}
