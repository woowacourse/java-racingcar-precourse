package racingcar;

import static racingcar.InputCarNames.getCarNames;
import static racingcar.InputTryCount.getTryCount;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        String[] carNames = getCarNames(scanner);
        int tryCount = getTryCount(scanner);
        Car[] racingCars = makeCars(carNames);
        // for debugging
        for (Car car : racingCars) {
            System.out.println(car.getName());
        }
    }

    public static Car[] makeCars(String[] carNames) {
        int carCount = carNames.length;
        Car[] racingCars = new Car[carCount];
        for (int i = 0; i < carCount; i++) {
            racingCars[i] = new Car(carNames[i]);
        }
        return racingCars;
    }
}
