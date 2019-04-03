package domain;

import java.util.ArrayList;

public class CarNavigator {
    private static final int STANDARD_OF_GOING = 4;
    private int randomNumber;
    private ArrayList<Car> carList;

    CarNavigator(ArrayList<Car> carList) {
        this.carList = carList;
    }

    public void MoveCars() {
        for (int carOrder = 0; carOrder < this.carList.size(); carOrder++) {
            MoveCarIfPossible(carOrder);
        }
    }

    private void MoveCarIfPossible(int carOrder) {
        if (isMove()) {
            MoveCar(carOrder);
        }
    }

    private void MoveCar(int carOrder) {
        this.carList.get(carOrder).Move();
    }

    private boolean isMove() {
        GenerateRandomNumber();
        return this.randomNumber >= STANDARD_OF_GOING ? true : false;
    }

    private void GenerateRandomNumber() {
        randomNumber = (int) (Math.random() * 10);
    }
}
