package utils;

import racingcar.Car;
import racingcar.GameManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputManager {
    public int carCount;

    public static List<Car> scanCarNames(Scanner scanner) {
        String[] carNames;
        List<Car> cars = new ArrayList<>();
        System.out.println(Sentences.ASK_CAR_NAME);
        carNames = scanner.nextLine().trim().split(",");
        checkCarNames(carNames);
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    public static int scanRound(Scanner scanner) {
        String input;
        int round;
        System.out.println(Sentences.ASK_TRACK_LENGTH);
        input = scanner.nextLine().trim();
        round = Integer.parseInt(input);
        return round;
    }

    private static IllegalArgumentException checkCarNames(String[] carNames) {
        for(String carName : carNames) {
            if(carName.length() > GameManager.MAXIMUM_CARNAME_LENGTH) {
                return new IllegalArgumentException(Sentences.MAXIMUM_CARNAME_LENGTH_ERROR);
            }
        }
        return null;
    }
}
