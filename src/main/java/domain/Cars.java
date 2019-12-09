package domain;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Cars {
    private static final int RANDOM_NUMBER_MAX = 9;

    private List<Car> cars;

    public Cars(String carNames) {
        this.cars = Arrays.stream(carNames.split(","))
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void play() {
        for (Car car : cars) {
            if (canProceed(getRandomNumber())) {
                car.proceed();
            }
        }
    }

    private int getRandomNumber() {
        return new Random().nextInt(RANDOM_NUMBER_MAX + 1);
    }

    private boolean canProceed(int randomNumber) {
        return randomNumber >= 4;
    }
}