package racingcar;

import utils.InputUtils;
import utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RacingStadium {
    private static Cars cars;
    private static int tryCount;

    private final InputUtils inputUtils;

    private RacingStadium(Scanner scanner) {
        this.inputUtils = InputUtils.of(scanner);
    }

    public static RacingStadium of(Scanner scanner) {
        return new RacingStadium(scanner);
    }

    public void start() {
        initializeCars();
        initializeTryCount();
        for (int i = 0; i < tryCount; i++) {
            playOnce();
        }
    }

    private void playOnce() {
        for (int carIndex = 0; carIndex < cars.size(); carIndex++) {
            Car nowCar = cars.get(carIndex);
            int randomNumber = getRandomNumber();
            nowCar.moveCar(randomNumber);
            nowCar.printStatus();
        }
        System.out.println();
    }

    private int getRandomNumber() {
        return RandomUtils.nextInt(0, 9);
    }

    private void initializeTryCount() {
        this.tryCount = inputUtils.getTryCount();
    }

    private void initializeCars() {
        String[] carNames = inputUtils.getCarNames();
        List<Car> carList = new ArrayList<>();
        for (String carName : carNames) {
            carList.add(new Car(carName));
        }
        this.cars = Cars.of(carList);
    }
}
