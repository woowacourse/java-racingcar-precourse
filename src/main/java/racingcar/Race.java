package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Race {
    private List<Car> allRacingCars = new ArrayList<>();

    public Race(Scanner scanner) {
        generateCars(scanner);
    }

    private void generateCars(Scanner scanner) {
        while (true) {
            System.out.println(Constant.PARTICIPATING_CAR_NAME_INPUT_MESSAGE);

            try {
                String input = scanner.nextLine();
                String[] cars = Stream.of(input.split(Constant.DELIMITER)).map(String::trim).toArray(String[]::new);

                checkRightCarName(cars);
                carRegistration(cars);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void checkRightCarName(String[] cars) {
        if (!Validation.carNameValidation(cars)) {
            throw new IllegalArgumentException(Constant.ERROR_CAR_NAME);
        }
    }

    private void carRegistration(String[] cars) {
        for (String carName : cars) {
            Car car = new Car(carName);
            allRacingCars.add(car);
        }
    }
}
