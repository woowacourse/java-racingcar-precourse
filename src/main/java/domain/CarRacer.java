package domain;

import java.util.ArrayList;

public class CarRacer {
    private static final int STANDARD_OF_GOING = 4;
    private int randomNumber;
    private ArrayList<Car> carList;

    CarRacer(ArrayList<Car> carList) {
        this.carList = carList;
    }

    private void MoveCar(int carOrder) {
        this.carList.get(carOrder).Go();
    }

    private boolean isGo() {
        return this.randomNumber >= STANDARD_OF_GOING ? true : false;
    }

    private void GenerateRandomNumber() {
        randomNumber = (int) (Math.random() * 10);
    }
}
