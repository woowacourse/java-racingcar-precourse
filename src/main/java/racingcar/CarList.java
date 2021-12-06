package racingcar;

import java.util.ArrayList;

public class CarList {
    private final ArrayList<Car> carList;

    public CarList(ArrayList<Car> carList) {
        this.carList = carList;
    }

    public ArrayList<Car> getCarList() {
        return carList;
    }
}
