package domain;

import java.util.List;

public class RacingCars {
    private final List<Car> carList;

    public RacingCars(List<Car> carList) {
        this.carList = carList;
    }

    public List<Car> getCarList() {
        return carList;
    }
}