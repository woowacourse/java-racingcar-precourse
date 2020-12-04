package domain;

import utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    private final static int RANDOM_MINIMUM = 0;
    private final static int RANDOM_MAXIMUM = 9;
    List<Car> carList = new ArrayList<>();

    public RacingCars(List<String> carNameList) {
        for (String carName : carNameList) {
            Car car = new Car(carName);
            carList.add(car);
        }
    }

    public void moveAllCar() {
        for (Car car : carList) {
            car.moveCar(RandomUtils.nextInt(RANDOM_MINIMUM,RANDOM_MAXIMUM));
        }
    }
}
