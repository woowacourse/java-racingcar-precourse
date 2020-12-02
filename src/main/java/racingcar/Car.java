package racingcar;

import utils.RandomUtils;

public class Car {
    private static int turnsToTry = 0;

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", position=" + position +
                ", turnsToTry=" + turnsToTry +
                '}';
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public static int getTurnsToTry() {
        return turnsToTry;
    }

    public static void setTurnsToTry(int turnsToTryParam) {
        turnsToTry = turnsToTryParam;
    }

    public void moveOrStay() {
        int randomValue = getRandomValue();
        if (isRandomValueMoreThan4(randomValue)) {
            position++;
        }
    }

    public int getRandomValue() {
        return RandomUtils.nextInt(0, 9);
    }

    public boolean isRandomValueMoreThan4(int randomValue) {
        return randomValue >= 4;
    }

    public static void useOneTurn() {
        turnsToTry--;
    }
}
