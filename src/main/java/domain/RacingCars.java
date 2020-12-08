package domain;

import utils.RandomUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private static final String SINGLE_CAR_UNAVAILABLE = "[ERROR] 한대의 차량으로는 경주할 수 없습니다.";
    private static final String COMMA_LAST_UNAVAILABLE = "[ERROR] 쉼표는 마지막으로 입력할 수 없습니다.";
    private static final int RANDOM_MINIMUM = 0;
    private static final int RANDOM_MAXIMUM = 9;
    private static final String SEPARATOR = ",";
    private static final char SEPARATOR_CHAR = ',';

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

    public static List<String> namesToNameList(String carNames) {
        isCommaLast(carNames);
        List<String> carNameList = Arrays.stream(carNames.split(SEPARATOR))
                .collect(Collectors.toList());
        isSingleCar(carNameList);
        return carNameList;
    }

    private static void isSingleCar(List<String> carNameList) {
        if (carNameList.size() == 1) {
            throw new IllegalArgumentException(SINGLE_CAR_UNAVAILABLE);
        }
    }

    private static void isCommaLast(String carNames) {
        if (carNames.charAt(carNames.length()-1) == SEPARATOR_CHAR) {
            throw new IllegalArgumentException(COMMA_LAST_UNAVAILABLE);
        }
    }

    public List<Car> getCarList() {
        return racingCarList;
    }
}
