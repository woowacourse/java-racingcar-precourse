package domain;

import java.util.Random;

public class Car {
    private final String name;
    private int position = 0;

    private static final int STANDARD = 3;

    public Car(String name) {
        this.name = name;
    }

    public static Car[] createCars(String[] carNames) {
        int N = carNames.length;
        Car[] cars = new Car[N];

        int idx = 0;
        for (String carName : carNames) {
            cars[idx++] = new Car(carName);
        }

        return cars;
    }

    public void updatePosition() {
        int randomNum = generateRandom();

        if (randomNum > 3) {
            position++;
        }
    }

    private int generateRandom() {
        return new Random().nextInt(9);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
