package domain;

import utils.RandomUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private static final int RANDOM_MINIMUM = 0;
    private static final int RANDOM_MAXIMUM = 9;
    private static final String SEPARATOR = ",";

    List<Car> racingCarList = new ArrayList<>();

    public RacingCars(String carNames) {
        for (String carName : namesToNameList(carNames)) {
            Car car = new Car(carName);
            racingCarList.add(car);
        }
    }

    public void moveAllCar() {
        for (Car car : racingCarList) {
            car.moveCar(RandomUtils.nextInt(RANDOM_MINIMUM,RANDOM_MAXIMUM));
        }
    }

    public static List<String> namesToNameList(String str) {
        return Arrays.stream(str.split(SEPARATOR))
                .collect(Collectors.toList());
    }

    public List<Car> getCarList() {
        return racingCarList;
    }
}
