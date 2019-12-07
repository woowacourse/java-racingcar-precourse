package domain;

import java.util.Random;

public class Game {
    public Game(String[] cars, int raceCount) {
        Car[] car = new Car[cars.length];
        for (int i = 0; i < cars.length; i++) {
            car[i] = new Car(cars[i]);
        }
        for (int i = 0; i < raceCount; i++) {
            this.currentResult(car);
        }
    }

    public void currentResult(Car[] car) {
        final int FORWORD = 4;
        Random random = new Random();
        for (Car i : car) {
            if (random.nextInt(10) >= FORWORD) {
                i.moveCar();
            }
            System.out.println(i.getName() + " : " + i.currentMove());
        }
        System.out.println();
    }
}
