package domain.Controller;

import domain.Model.Car;

import java.util.ArrayList;
import java.util.Collections;

public class CarManager {
    Car[] cars;
    int carsLength;
    int maxPosition;
    ArrayList<Integer> positionList;

    public CarManager(String[] carNames) {
        this.carsLength = carNames.length;
        cars = new Car[carsLength];
        for (int i = 0; i < carsLength; i++) {
            cars[i] = new Car(carNames[i]);
        }
        this.positionList = new ArrayList<>();
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

    private void setPositionList() {
        for (Car car : cars) {
            this.positionList.add(car.getPosition());
        }
    }

    private void setMaxPositions() {
        setPositionList();
        this.maxPosition = Collections.max(this.positionList);
    }

    public void whoIsWinner() {
        setMaxPositions();
        System.out.print("<< ");
        for (Car car : cars) {
            if (car.getPosition() == this.maxPosition) {
                System.out.print(car.getName() + " ");
            }
        }
        System.out.println(">> 최종 우승!!");
    }

}
