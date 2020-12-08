package domain;

import utils.RandomUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private static final String SINGLE_CAR_UNAVAILABLE = "[ERROR] 한대의 차량으로는 경주할 수 없습니다.";
    private static final int RANDOM_MINIMUM = 0;
    private static final int RANDOM_MAXIMUM = 9;
    private static final String SEPARATOR = ",";
    private static final int UNAVAILABLE_CAR_NUMBER = 1;

    private List<Car> racingCarList = new ArrayList<>();

    public RacingCars(String carNames) {
        for (String carName : namesToNameList(carNames)) {
            Car car = new Car(carName);
            racingCarList.add(car);
        }
    }

    public void moveAllCar() {
        for (Car car : racingCarList) {
            car.moveCar(RandomUtils.nextInt(RANDOM_MINIMUM, RANDOM_MAXIMUM));
        }
    }

    public static List<String> namesToNameList(String carNames) {
        List<String> carNameList = Arrays.stream(carNames.split(SEPARATOR))
                .collect(Collectors.toList());
        isSingleCar(carNameList);
        return carNameList;
    }

    private static void isSingleCar(List<String> carNameList) {
        if (carNameList.size() == UNAVAILABLE_CAR_NUMBER) {
            throw new IllegalArgumentException(SINGLE_CAR_UNAVAILABLE);
        }
    }

    public List<Car> getCarList() {
        return racingCarList;
    }
}
