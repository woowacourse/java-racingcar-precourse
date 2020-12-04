package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;

    public Cars(List<String> carNames) {
        this.cars = convertStringToCar(carNames);
    }

    public void moveByRandomNumber() {
        for (Car car : cars) {
            int randomNumber = RandomNumberGenerator.generateRandomNumber();
            car.moveIfRandomNumberIsBiggerThanLimit(randomNumber);
        }

    }

    public void showCarsCurrentPosition() {
        for (Car car : cars) {
            System.out.println(car);
        }
        System.out.println();
    }

    private List<Car> convertStringToCar(List<String> carNames) {
        return carNames.stream()
            .map(Car::new)
            .collect(Collectors.toList());
    }


}
