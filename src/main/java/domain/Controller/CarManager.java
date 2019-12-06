package domain.Controller;

import domain.Model.Car;

import java.util.Random;

public class CarManager {
    Car[] cars;
    int carsLength;

    public CarManager(String[] carNames) {
        this.carsLength = carNames.length;
        cars = new Car[carsLength];
        for (int i = 0; i < carsLength; i++) {
            cars[i] = new Car(carNames[i]);
        }


    }

    public void ifBiggerThanFourYouCanMove(int randomNumber, int carIndex) {
        if (randomNumber >= 4) {
                cars[carIndex].move();
        }
    }

    public void printCarsNameAndPosition() {
        for (Car car : cars) {
            System.out.println(car.getName()
                    + ": " + car.getPosition());
        }
    }

    public int getCarsLength() {
        return this.carsLength;
    }

}
